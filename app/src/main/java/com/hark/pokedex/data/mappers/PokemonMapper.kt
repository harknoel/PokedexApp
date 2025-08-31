package com.hark.pokedex.data.mappers

import com.hark.pokedex.data.remote.dto.pokemon.PokemonDto
import com.hark.pokedex.data.remote.dto.pokemon.TypeDto
import com.hark.pokedex.data.remote.dto.pokemon_species.PokemonSpeciesDto
import com.hark.pokedex.domain.model.Ability
import com.hark.pokedex.domain.model.Pokemon
import com.hark.pokedex.domain.model.PokemonStat
import com.hark.pokedex.domain.model.PokemonType
import javax.inject.Inject
class PokemonMapper @Inject constructor() {
    fun toDomain(
        dto: PokemonDto,
        speciesDto: PokemonSpeciesDto
    ): Pokemon {
        return Pokemon(
            id = dto.id,
            name = dto.name,
            height = dto.height,
            weight = dto.weight,
            order = dto.order,
            baseExperience = dto.baseExperience,
            imageUrl = dto.sprites.other.officialArtwork.frontDefault,
            types = dto.types.map { mapToPokemonType(it.type.name) },
            stats = dto.stats.map { mapToPokemonStat(it.stat.name, it.baseStat) },
            abilities = dto.abilities.map { Ability(it.ability.name, it.ability.url) },
            baseHappiness = speciesDto.baseHappiness,
            captureRate = speciesDto.captureRate,
            habitat = speciesDto.habitat.name,
            flavorText = speciesDto.flavorTextEntries
                .firstOrNull { it.language.name == "en" }?.flavorText
                ?: speciesDto.flavorTextEntries.firstOrNull()?.flavorText
        )
    }

    private fun mapToPokemonType(typeName: String): PokemonType {
        return when (typeName.lowercase()) {
            "normal" -> PokemonType.Normal
            "fire" -> PokemonType.Fire
            "water" -> PokemonType.Water
            "grass" -> PokemonType.Grass
            "electric" -> PokemonType.Electric
            "ice" -> PokemonType.Ice
            "fighting" -> PokemonType.Fighting
            "poison" -> PokemonType.Poison
            "ground" -> PokemonType.Ground
            "flying" -> PokemonType.Flying
            "psychic" -> PokemonType.Psychic
            "bug" -> PokemonType.Bug
            "rock" -> PokemonType.Rock
            "ghost" -> PokemonType.Ghost
            "dark" -> PokemonType.Dark
            "dragon" -> PokemonType.Dragon
            "steel" -> PokemonType.Steel
            "fairy" -> PokemonType.Fairy
            else -> PokemonType.Unknown
        }
    }

    private fun mapToPokemonStat(statName: String, baseStat: Int): PokemonStat {
        return when (statName.lowercase()) {
            "hp" -> PokemonStat.Hp(baseStat)
            "attack" -> PokemonStat.Attack(baseStat)
            "defense" -> PokemonStat.Defense(baseStat)
            "special-attack" -> PokemonStat.SpecialAttack(baseStat)
            "special-defense" -> PokemonStat.SpecialDefense(baseStat)
            "speed" -> PokemonStat.Speed(baseStat)
            else -> PokemonStat.Hp(baseStat)
        }
    }
}
