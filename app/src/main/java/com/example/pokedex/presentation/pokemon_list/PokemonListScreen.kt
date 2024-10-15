package com.example.pokedex.presentation.pokemon_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
    Surface {
        Column {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.pokemon_logo),
                contentDescription = "Pokemon logo"
            )
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