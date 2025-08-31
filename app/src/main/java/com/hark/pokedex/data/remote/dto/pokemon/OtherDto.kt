package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName


data class OtherDto(
    val showdown: ShowdownDto,

    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtworkDto,
)