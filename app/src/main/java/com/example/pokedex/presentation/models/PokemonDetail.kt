package com.example.pokedex.presentation.models

data class PokemonDetail(
    val pokemonName: String,
    val type1: String,
    val type2: String?,
    val weight: Int,
    val height: Int,
    val imageUrl: String,
    val baseStats: Map<String, Int>
)

/*data class Stat(
    val statName: String,
    val statValue: Int
)*/
