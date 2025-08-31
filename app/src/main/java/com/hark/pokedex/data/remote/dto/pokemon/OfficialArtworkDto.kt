package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName

data class OfficialArtworkDto(

    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_shiny")
    val frontShiny: String
)