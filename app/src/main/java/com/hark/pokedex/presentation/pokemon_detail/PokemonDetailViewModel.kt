package com.hark.pokedex.presentation.pokemon_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hark.pokedex.data.remote.ApiOperation
import com.hark.pokedex.domain.model.Pokemon
import com.hark.pokedex.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    private val _pokemonDetail = MutableLiveData<Pokemon?>()
    val pokemonDetail: LiveData<Pokemon?> = _pokemonDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadPokemonDetail(pokemonId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            when (val result = getPokemonDetailUseCase(pokemonId)) {
                is ApiOperation.Success -> {
                    _pokemonDetail.value = result.data
                }
                is ApiOperation.Failure -> {
                    _error.value = result.exception.message ?: "Unknown error occurred"
                }
            }
            _isLoading.value = false
        }
    }
}
