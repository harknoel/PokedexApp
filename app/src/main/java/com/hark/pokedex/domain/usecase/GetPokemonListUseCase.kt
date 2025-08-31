package com.hark.pokedex.domain.usecase

import androidx.paging.PagingData
import com.hark.pokedex.domain.model.Pokemon
import com.hark.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(): Flow<PagingData<Pokemon>> {
        return repository.getPokemonList()
    }
}
