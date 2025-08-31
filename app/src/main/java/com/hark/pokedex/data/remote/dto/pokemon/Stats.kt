package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName

data class Stats(
    val effort: Int,
    val stat: Stat,

    @SerializedName("base_stat")
    val baseStat: Int
)