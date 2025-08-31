package com.hark.pokedex.presentation.navigation

sealed class Route(val route: String) {
    object AppStartNavigation : Route(route = "app_start_navigation")
    object OnBoardingScreen : Route(route = "onboarding_screen")
    object PokedexNavigation : Route(route = "pokedex_navigation")
    object HomeScreen : Route(route = "home_screen")
    object PokemonCompareScreen : Route(route = "pokemon_compare_screen")
    object PokemonListScreen : Route(route = "pokemon_list_screen")
    object PokemonEncounterScreen : Route(route = "pokemon_encounter_screen")
    object PokemonDetailsScreen : Route(route = "pokemon_details_screen/{pokemonId}") {
        fun createRoute(pokemonId: Int) = "pokemon_details_screen/$pokemonId"
    }
}
