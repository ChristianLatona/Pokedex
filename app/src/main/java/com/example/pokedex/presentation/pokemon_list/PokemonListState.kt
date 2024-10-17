package com.example.pokedex.presentation.pokemon_list

import com.example.pokedex.presentation.models.Pokemon

data class PokemonListState(
    val pokemonList: List<Pokemon> = emptyList()
)