package com.example.pokedex.presentation.pokemon_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.use_case.PokemonUseCases
import com.example.pokedex.presentation.models.PokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val pokemonUseCases: PokemonUseCases
): ViewModel() {

    //Qui andrebbe fatta la gestione dell'intent, ma sto usando il produceState

    private val _state = mutableStateOf(PokemonDetailState())
    val state: State<PokemonDetailState> = _state

    suspend fun getPokemonDetail(pokemonName: String): PokemonDetail {
        return pokemonUseCases.getPokemonDetail(pokemonName)
    }

}