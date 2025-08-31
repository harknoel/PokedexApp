package com.hark.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hark.pokedex.data.mappers.PokemonMapper
import com.hark.pokedex.data.remote.ApiOperation
import com.hark.pokedex.data.remote.PokeApiService
import com.hark.pokedex.data.remote.PokemonPagingSource
import com.hark.pokedex.domain.model.Pokemon
import com.hark.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApiService,
    private val mapper: PokemonMapper
) : PokemonRepository {

    override fun getPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                prefetchDistance = 3
            ),
            pagingSourceFactory = { PokemonPagingSource(api, mapper) }
        ).flow
    }

    override suspend fun getPokemonDetail(pokemonId: Int): ApiOperation<Pokemon> {
        return safeApiCall {
            val pokemonDto = api.getPokemonDetail(pokemonId)
            val speciesDto = api.getPokemonSpecies(pokemonId)
            mapper.toDomain(pokemonDto, speciesDto)
        }
    }

    private inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> {
        return try {
            ApiOperation.Success(data = apiCall())
        } catch (e: Exception) {
            ApiOperation.Failure(exception = e)
        }
    }
}

