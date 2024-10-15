package com.example.pokedex.presentation.pokemon_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.use_case.PokemonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonUseCases: PokemonUseCases
): ViewModel() {

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            pokemonUseCases.getPokemonListUseCase()
        }
    }
}