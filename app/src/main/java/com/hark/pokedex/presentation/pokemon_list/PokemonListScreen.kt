package com.hark.pokedex.presentation.pokemon_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun PokemonListScreen(
    viewModel: PokemonViewModel = hiltViewModel()
) {
    val lazyPagingItems = viewModel.pokemonList.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(lazyPagingItems.itemCount) { index ->
            val pokemon = lazyPagingItems[index]
            Text(text = pokemon?.name ?: "Unknown")
        }

        lazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { Text("Loading...") }
                }
                loadState.append is LoadState.Loading -> {
                    item { Text("Loading more...") }
                }
                loadState.append is LoadState.Error -> {
                    item { Text("Error loading more!") }
                }
            }
        }
    }
}