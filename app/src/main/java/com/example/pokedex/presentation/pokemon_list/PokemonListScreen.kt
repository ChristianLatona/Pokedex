package com.example.pokedex.presentation.pokemon_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokedex.PokemonDetailRoute
import com.example.pokedex.R
import com.example.pokedex.presentation.pokemon_list.composables.PokemonListItem

@Composable
fun PokemonListScreen (
    navController: NavController,
    pokemonListViewModel: PokemonListViewModel
) {

    val pokemonListLazyPagingItems = pokemonListViewModel.pokemonItemPagingFlow.collectAsLazyPagingItems()

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.pokemon_logo),
                contentDescription = "Pokemon logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(
                    count = pokemonListLazyPagingItems.itemCount
                ) { index ->
                    val pokemon = pokemonListLazyPagingItems[index]
                    if (pokemon != null) {
                        PokemonListItem(
                            pokemonListItem = pokemon
                        ) {
                            navController.navigate(PokemonDetailRoute(
                                pokemonName = pokemon.pokemonName
                            ))
                        }
                    }
                }
                item {
                    if (pokemonListLazyPagingItems.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}