package com.example.pokedex.presentation.pokemon_list

import com.example.pokedex.presentation.models.PokemonItem

data class PokemonListState(
    val pokemonList: List<PokemonItem> = emptyList()
)