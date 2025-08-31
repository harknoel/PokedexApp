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
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonListResponseDto

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") pokemonId: Int): PokemonDto

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpecies(@Path("id") pokemonId: Int): PokemonSpeciesDto
}
