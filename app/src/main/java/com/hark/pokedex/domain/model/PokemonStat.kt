package com.hark.pokedex.domain.model

sealed class PokemonStat(val displayName: String, val value: Int) {
    class Hp(baseStat: Int) : PokemonStat("HP", baseStat)
    class Attack(baseStat: Int) : PokemonStat("Attack", baseStat)
    class Defense(baseStat: Int) : PokemonStat("Defense", baseStat)
    class SpecialAttack(baseStat: Int) : PokemonStat("Special Attack", baseStat)
    class SpecialDefense(baseStat: Int) : PokemonStat("Special Defense", baseStat)
    class Speed(baseStat: Int) : PokemonStat("Speed", baseStat)
}

