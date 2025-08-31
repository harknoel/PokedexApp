package com.hark.pokedex.domain.repository

import androidx.paging.PagingData
import com.hark.pokedex.data.remote.dto.pokemon_list.ResultDto
import com.hark.pokedex.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonList(): Flow<PagingData<ResultDto>>
}
