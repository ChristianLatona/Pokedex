package com.example.pokedex.presentation.pokemon_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.paging.compose.items
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
        Column {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.pokemon_logo),
                contentDescription = "Pokemon logo",
                /*modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)*/
            )
            Spacer(Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(pokemonListLazyPagingItems) { pokemon -> // items è una funzione del lazyPaging che cicla gli items
                    if (pokemon != null) {
                        PokemonListItem(pokemon)
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