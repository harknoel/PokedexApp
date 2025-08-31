package com.hark.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hark.pokedex.domain.repository.PokemonCacheRepository
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
    private val mapper: PokemonMapper,
    private val cache: PokemonCacheRepository
) : PokemonRepository {

    override fun getPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                prefetchDistance = 3
            ),
            pagingSourceFactory = { PokemonPagingSource(api, mapper, cache) }
        ).flow
    }

    override suspend fun getPokemonDetail(pokemonId: Int): ApiOperation<Pokemon> {
        return safeApiCall {
            val cachedPokemon = cache.getPokemon(pokemonId)
            if (cachedPokemon != null) {
                return@safeApiCall cachedPokemon
            }

            val pokemonDto = api.getPokemonDetail(pokemonId)
            val speciesDto = api.getPokemonSpecies(pokemonId)
            val pokemon = mapper.toDomain(pokemonDto, speciesDto)

            cache.savePokemon(pokemon)
            pokemon
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
