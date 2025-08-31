package com.hark.pokedex.data.remote.dto.pokemon_species

import com.google.gson.annotations.SerializedName

data class FlavorTextEntry(
    val language: Language,
    val version: Version,

    @SerializedName("flavor_text")
    val flavorText: String
)