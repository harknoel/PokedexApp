package com.hark.pokedex.data.remote.dto.pokemon_list

data class PokemonListDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ResultDto>
)