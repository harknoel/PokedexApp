package com.hark.pokedex.presentation.onboarding

import androidx.annotation.DrawableRes
import com.hark.pokedex.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Welcome to Your Pokedex!",
        description = "Track every Pokemon you encounter on your journey! Whether you're exploring tall grass, battling trainers, or discovering rare species, your Pokédex keeps a record of them all. Start building your collection and see how far you've come!",
        image = R.drawable.onboarding_pokemon
    ),
    Page(
        title = "Browse & Compare Pokemon",
        description = "Explore a complete list of Pokemon with detailed stats, evolutions, types, and abilities. Want to know which Pokemon is stronger or faster? Use the comparison tool to analyze two Pokemon side by side and make smarter choices for your team!",
        image = R.drawable.onboarding_pokemon_water
    ),
    Page(
        title = "Search & Discover Pokemon",
        description = "Find any Pokemon instantly using our advanced search. Filter by name, type, or ability to quickly uncover new favorites or plan your next battle strategy. Whether you’re exploring for fun or building a stronger team, your next discovery is just a tap away!",
        image = R.drawable.onboarding_rayquaza
    )
)
