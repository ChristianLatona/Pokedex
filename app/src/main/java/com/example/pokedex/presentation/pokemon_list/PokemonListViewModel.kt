package com.example.pokedex.presentation.pokemon_list

import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.repository.PokemonRepositoryImpl
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepositoryImpl
): ViewModel() {

    //private val _state =
}