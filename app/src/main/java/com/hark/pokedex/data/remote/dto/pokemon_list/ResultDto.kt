package com.hark.pokedex.data.remote.dto.pokemon_list

import com.hark.pokedex.domain.model.Pokemon

data class ResultDto(
    val name: String,
    val url: String
) {
    fun toDomain(): Pokemon = Pokemon(name, url)
}