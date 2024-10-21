package com.example.pokedex.presentation.pokemon_list.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.presentation.models.PokemonListItem
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonListItem(
    pokemonListItem: PokemonListItem,
    onClick: () -> Unit
) {
    // si può fare effettivamente con un box
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Row {
            AsyncImage(
                model = pokemonListItem.imageUrl,
                contentDescription = pokemonListItem.pokemonName,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
            )
            Text(
                text = pokemonListItem.pokemonName,
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
            PokemonListItem(
                pokemonName = "Bulbasaur",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
            )
        ) {}
    }
}