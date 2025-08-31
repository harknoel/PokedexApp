package com.hark.pokedex.data.repository

import com.hark.pokedex.domain.repository.PokemonCacheRepository
import com.hark.pokedex.domain.model.Pokemon
import javax.inject.Inject

class PokemonCacheRepositoryImpl @Inject constructor() : PokemonCacheRepository {
    private val pokemonCache = mutableMapOf<Int, Pokemon>()
    private val listCache = mutableMapOf<String, List<Pokemon>>()

    override suspend fun getPokemon(pokemonId: Int): Pokemon? {
        return pokemonCache[pokemonId]
    }

    override suspend fun savePokemon(pokemon: Pokemon) {
        pokemonCache[pokemon.id] = pokemon
    }

    override suspend fun getPokemonList(offset: Int, limit: Int): List<Pokemon>? {
        val key = "${offset}_${limit}"
        return listCache[key]
    }

    override suspend fun savePokemonList(pokemonList: List<Pokemon>, offset: Int, limit: Int) {
        val key = "${offset}_${limit}"
        listCache[key] = pokemonList
        pokemonList.forEach { pokemon ->
            pokemonCache[pokemon.id] = pokemon
        }
    }

    override suspend fun clearCache() {
        pokemonCache.clear()
        listCache.clear()
    }
}