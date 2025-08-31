package com.hark.pokedex.domain.repository

import com.hark.pokedex.domain.model.Pokemon

interface PokemonCacheRepository {
    suspend fun getPokemon(pokemonId: Int): Pokemon?
    suspend fun savePokemon(pokemon: Pokemon)
    suspend fun getPokemonList(offset: Int, limit: Int): List<Pokemon>?
    suspend fun savePokemonList(pokemonList: List<Pokemon>, offset: Int, limit: Int)
    suspend fun clearCache()
}