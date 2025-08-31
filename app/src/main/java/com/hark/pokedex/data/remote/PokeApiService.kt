package com.hark.pokedex.data.remote

import com.hark.pokedex.data.remote.dto.pokemon_list.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Query
interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonListDto
}
