package com.example.pokedex.presentation.pokemon_list.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.presentation.models.Pokemon
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonListItem(
    pokemon: Pokemon
) {
    // si può fare effettivamente con un box
    Card(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .shadow(1.dp)
    ) {
        Row {
            AsyncImage(
                model = pokemon.imageUrl,
                contentDescription = pokemon.pokemonName,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
            )
            Text(
                text = pokemon.pokemonName,
                modifier = Modifier
                    .weight(8f)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PokedexTheme {
        PokemonListItem(
            Pokemon(
                pokemonName = "Bulbasaur",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
            )
        )
    }
}