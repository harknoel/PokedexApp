package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    val abilities: List<Abilities>,
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stats>,
    val types: List<Types>,
    val weight: Int,

    @SerializedName("base_experience")
    val baseExperience: Int,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String
)