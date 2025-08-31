package com.hark.pokedex.data.remote

import com.hark.pokedex.data.remote.dto.pokemon.PokemonDto
import com.hark.pokedex.data.remote.dto.pokemon_list.PokemonListResponseDto
import com.hark.pokedex.data.remote.dto.pokemon_species.PokemonSpeciesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponseDto

    @GET("pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") id: Int
    ): PokemonDto

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpeciesById(
        @Path("id") id: Int
    ): PokemonSpeciesDto
}
