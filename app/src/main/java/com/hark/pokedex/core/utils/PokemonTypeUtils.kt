package com.hark.pokedex.core.utils

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.Color
import com.hark.pokedex.R
import com.hark.pokedex.domain.model.PokemonType
import javax.inject.Inject

fun PokemonType.asColor(): Color {
    return when (this) {
        PokemonType.Fire -> Color(0xFFFF6B35)
        PokemonType.Water -> Color(0xFF3B82F6)
        PokemonType.Grass -> Color(0xFF10B981)
        PokemonType.Electric -> Color(0xFFFCD34D)
        PokemonType.Psychic -> Color(0xFFA855F7)
        PokemonType.Ice -> Color(0xFF60A5FA)
        PokemonType.Dragon -> Color(0xFF7C3AED)
        PokemonType.Dark -> Color(0xFF374151)
        PokemonType.Fighting -> Color(0xFFDC2626)
        PokemonType.Poison -> Color(0xFF9333EA)
        PokemonType.Ground -> Color(0xFFD97706)
        PokemonType.Flying -> Color(0xFF06B6D4)
        PokemonType.Bug -> Color(0xFF65A30D)
        PokemonType.Rock -> Color(0xFF78716C)
        PokemonType.Ghost -> Color(0xFF6B21A8)
        PokemonType.Steel -> Color(0xFF64748B)
        PokemonType.Fairy -> Color(0xFFEC4899)
        PokemonType.Normal -> Color(0xFF6B7280)
        PokemonType.Unknown -> Color(0xFF6B7280)
    }
}

fun PokemonType.asIcon(): Int {
    return when (this) {
        PokemonType.Fire -> R.drawable.type_fire
        PokemonType.Water -> R.drawable.type_water
        PokemonType.Grass -> R.drawable.type_grass
        PokemonType.Electric -> R.drawable.type_electric
        PokemonType.Psychic -> R.drawable.type_psychic
        PokemonType.Ice -> R.drawable.type_ice
        PokemonType.Dragon -> R.drawable.type_dragon
        PokemonType.Dark -> R.drawable.type_dark
        PokemonType.Fighting -> R.drawable.type_fighting
        PokemonType.Poison -> R.drawable.type_poison
        PokemonType.Ground -> R.drawable.type_ground
        PokemonType.Flying -> R.drawable.type_flying
        PokemonType.Bug -> R.drawable.type_bug
        PokemonType.Rock -> R.drawable.type_rock
        PokemonType.Ghost -> R.drawable.type_ghost
        PokemonType.Steel -> R.drawable.type_steel
        PokemonType.Fairy -> R.drawable.type_fairy
        PokemonType.Normal -> R.drawable.type_normal
        PokemonType.Unknown -> R.drawable.type_normal
    }
}


