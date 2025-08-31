package com.hark.pokedex.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hark.pokedex.data.mappers.PokemonMapper
import com.hark.pokedex.domain.model.Pokemon

class PokemonPagingSource(
    private val api: PokeApiService,
    private val mapper: PokemonMapper
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

            val response = api.getPokemonList(offset = offset, limit = params.loadSize)

            val pokemonList = response.results.mapNotNull { result ->
                try {
                    val pokemonId = extractPokemonId(result.url)
                    val pokemonDto = api.getPokemonDetail(pokemonId)
                    val speciesDto = api.getPokemonSpecies(pokemonId)
                    mapper.toDomain(pokemonDto, speciesDto)
                } catch (e: Exception) {
                    null
                }
            }

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
