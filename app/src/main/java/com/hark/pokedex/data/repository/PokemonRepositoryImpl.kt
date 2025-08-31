package com.hark.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.hark.pokedex.data.mappers.PokemonMapper
import com.hark.pokedex.data.remote.PokeApiService
import com.hark.pokedex.data.remote.PokemonPagingSource
import com.hark.pokedex.data.remote.dto.pokemon_list.ResultDto
import com.hark.pokedex.domain.model.Pokemon
import com.hark.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApiService,
    private val mapper: PokemonMapper
) : PokemonRepository {

    override fun getPokemonList(): Flow<PagingData<ResultDto>> {
        return Pager(
            config = PagingConfig(pageSize = 30, enablePlaceholders = false),
            pagingSourceFactory = { PokemonPagingSource(api, mapper) }
        ).flow
    }
}
