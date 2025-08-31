package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    val abilities: List<AbilitiesDto>,
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val species: SpeciesDto,
    val sprites: SpritesDto,
    val stats: List<StatsDto>,
    val types: List<TypesDto>,
    val weight: Int,

    @SerializedName("base_experience")
    val baseExperience: Int,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String
)