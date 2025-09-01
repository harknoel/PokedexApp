package com.hark.pokedex.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.hark.pokedex.presentation.onboarding.OnBoardingScreen
import com.hark.pokedex.presentation.onboarding.OnBoardingViewModel
import com.hark.pokedex.presentation.pokemon_list.PokemonListScreen

@Composable
fun PokedexNavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }


        navigation(
            route = Route.PokedexNavigation.route,
            startDestination = Route.PokemonListScreen.route
        ) {
            composable(route = Route.PokemonListScreen.route) {
                PokemonListScreen(
                    onPokemonClick = { pokemonId ->
                        navController.navigate(Route.PokemonDetailsScreen.createRoute(pokemonId))
                    },
                )
            }
        }
    }
}
