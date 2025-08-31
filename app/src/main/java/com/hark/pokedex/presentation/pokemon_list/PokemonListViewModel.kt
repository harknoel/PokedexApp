package com.hark.pokedex.presentation.pokemon_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hark.pokedex.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    val pokemonList = getPokemonListUseCase()
        .cachedIn(viewModelScope)
}
