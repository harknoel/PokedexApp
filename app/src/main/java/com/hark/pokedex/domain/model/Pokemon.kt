package com.hark.pokedex.domain.model

import com.hark.pokedex.data.remote.dto.pokemon.AbilityDto

data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val order: Int,
    val baseExperience: Int,
    val imageUrl: String,
    val types: List<PokemonType>,
    val stats: List<PokemonStat>,
    val abilities: List<Ability>,

    val baseHappiness: Int,
    val captureRate: Int,
    val habitat: String?,
    val flavorText: String?
)

