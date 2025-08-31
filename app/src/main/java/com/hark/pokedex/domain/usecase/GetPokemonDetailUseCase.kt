package com.hark.pokedex.domain.usecase

import com.hark.pokedex.data.remote.ApiOperation
import com.hark.pokedex.domain.model.Pokemon
import com.hark.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject
class GetPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(pokemonId: Int): ApiOperation<Pokemon> {
        return repository.getPokemonDetail(pokemonId)
    }
}