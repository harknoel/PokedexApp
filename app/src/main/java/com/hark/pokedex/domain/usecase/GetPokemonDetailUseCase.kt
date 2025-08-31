package com.hark.pokedex.domain.usecase

import com.hark.pokedex.domain.model.Pokemon
import com.hark.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(pokemonId: Int): Pokemon {
        return repository.getPokemonDetail(pokemonId)
    }
}