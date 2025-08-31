package com.hark.pokedex.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hark.pokedex.presentation.pokemon_list.PokemonListScreen

@Composable
fun PokedexNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "pokemon_list"
    ) {
        composable("pokemon_list") {
            PokemonListScreen(
                onPokemonClick = { pokemonId ->
                    navController.navigate(Route.PokemonDetailsScreen.createRoute(pokemonId))
                },
            )
        }
    }
}