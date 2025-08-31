package com.hark.pokedex.data.remote.dto.pokemon

import com.google.gson.annotations.SerializedName

data class AbilitiesDto(
    val ability: AbilityDto,
    val slot: Int,

    @SerializedName("is_hidden")
    val isHidden: Boolean
)