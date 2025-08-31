package com.hark.pokedex.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hark.pokedex.data.remote.dto.pokemon_list.ResultDto
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val api: PokeApiService
) : PagingSource<Int, ResultDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultDto> {
        return try {
            val page = params.key ?: 0
            val limit = params.loadSize
            val offset = page * limit

            val response = api.getPokemonList(offset, limit)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResultDto>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}
