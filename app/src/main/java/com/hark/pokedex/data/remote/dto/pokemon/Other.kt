package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName


data class Other(
    val showdown: Showdown,

    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork,
)