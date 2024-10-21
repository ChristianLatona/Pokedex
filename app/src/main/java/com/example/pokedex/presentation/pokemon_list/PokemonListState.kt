package com.example.pokedex.presentation.pokemon_list

import com.example.pokedex.presentation.models.PokemonListItem

data class PokemonListState(
    val pokemonListItemList: List<PokemonListItem> = emptyList()
)