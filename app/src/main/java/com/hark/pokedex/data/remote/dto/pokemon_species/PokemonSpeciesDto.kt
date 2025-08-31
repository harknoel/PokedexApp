package com.hark.pokedex.data.remote.dto.pokemon_species

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesDto(
    val color: Color,
    val generation: Generation,
    val habitat: Habitat,
    val id: Int,
    val name: String,
    val names: List<Name>,
    val order: Int,
    val shape: Shape,

    @SerializedName("base_happiness")
    val baseHappiness: Int,

    @SerializedName("capture_rate")
    val captureRate: Int,

    @SerializedName("egg_groups")
    val eggGroups: List<EggGroup>,

    @SerializedName("evolution_chain")
    val evolutionChain: EvolutionChain,

    @SerializedName("hatch_counter")
    val hatchCounter: Int,

    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>
)