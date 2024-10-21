package com.example.pokedex.presentation.pokemon_detail

import com.example.pokedex.presentation.models.PokemonDetail


class PokemonDetailState(
  val pokemonDetail: PokemonDetail? = null,
  val isLoading: Boolean = true
)