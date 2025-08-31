package com.hark.pokedex.data.remote.dto.pokemon_list

data class PokemonListResponseDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ResultDto>
)