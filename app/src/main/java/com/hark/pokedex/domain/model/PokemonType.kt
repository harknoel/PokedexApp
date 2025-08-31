package com.hark.pokedex.domain.model

sealed class PokemonType(val displayName: String) {
    object Normal : PokemonType("Normal")
    object Fire : PokemonType("Fire")
    object Water : PokemonType("Water")
    object Grass : PokemonType("Grass")
    object Electric : PokemonType("Electric")
    object Ice : PokemonType("Ice")
    object Fighting : PokemonType("Fighting")
    object Poison : PokemonType("Poison")
    object Ground : PokemonType("Ground")
    object Flying : PokemonType("Flying")
    object Psychic : PokemonType("Psychic")
    object Bug : PokemonType("Bug")
    object Rock : PokemonType("Rock")
    object Ghost : PokemonType("Ghost")
    object Dark : PokemonType("Dark")
    object Dragon : PokemonType("Dragon")
    object Steel : PokemonType("Steel")
    object Fairy : PokemonType("Fairy")
    object Unknown : PokemonType("Unknown")
}

