package com.example.pokedex.presentation.pokemon_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.R
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonListScreen (
    navController: NavController
) {
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
            LazyColumn() {

            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PokedexTheme {
        PokemonListScreen(
            navController = rememberNavController()
        )
    }
}