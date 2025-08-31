package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName

data class StatsDto(
    val effort: Int,
    val stat: StatDto,

    @SerializedName("base_stat")
    val baseStat: Int
)