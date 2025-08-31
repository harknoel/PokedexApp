package com.hark.pokedex.domain.model

sealed class PokemonStat(val displayName: String, val baseStat: Int) {
    class Hp(baseStat: Int) : PokemonStat("hp", baseStat)
    class Attack(baseStat: Int) : PokemonStat("attack", baseStat)
    class Defense(baseStat: Int) : PokemonStat("defense", baseStat)
    class SpecialAttack(baseStat: Int) : PokemonStat("special-attack", baseStat)
    class SpecialDefense(baseStat: Int) : PokemonStat("special-defense", baseStat)
    class Speed(baseStat: Int) : PokemonStat("speed", baseStat)
}

