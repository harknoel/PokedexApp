package com.hark.pokedex.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hark.pokedex.domain.repository.PokemonCacheRepository
import com.hark.pokedex.data.mappers.PokemonMapper
import com.hark.pokedex.domain.model.Pokemon

class PokemonPagingSource(
    private val api: PokeApiService,
    private val mapper: PokemonMapper,
    private val cache: PokemonCacheRepository,
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val page = params.key ?: 0
            val offset = page * params.loadSize

            val cachedList = cache.getPokemonList(offset, params.loadSize)
            if (cachedList != null && cachedList.isNotEmpty()) {
                return LoadResult.Page(
                    data = cachedList,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = if (cachedList.size < params.loadSize) null else page + 1
                )
            }

            val response = api.getPokemonList(offset = offset, limit = params.loadSize)

            val pokemonList = response.results.mapNotNull { result ->
                try {
                    val pokemonId = extractPokemonId(result.url)

                    val cachedPokemon = cache.getPokemon(pokemonId)
                    if (cachedPokemon != null) {
                        cachedPokemon
                    } else {
                        val pokemonDto = api.getPokemonDetail(pokemonId)
                        val speciesDto = api.getPokemonSpecies(pokemonId)
                        val pokemon = mapper.toDomain(pokemonDto, speciesDto)
                        cache.savePokemon(pokemon)
                        pokemon
                    }
                } catch (e: Exception) {
                    null
                }
            }

            cache.savePokemonList(pokemonList, offset, params.loadSize)

            LoadResult.Page(
                data = pokemonList,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.next.isNullOrEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun extractPokemonId(url: String): Int {
        return url.trimEnd('/').split("/").last().toInt()
    }
}
