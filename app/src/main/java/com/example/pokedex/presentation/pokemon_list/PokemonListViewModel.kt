package com.example.pokedex.presentation.pokemon_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.pokedex.data.data_source.local.PokemonEntity
import com.example.pokedex.data.data_source.toPokemon
import com.example.pokedex.domain.use_case.PokemonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    pokemonUseCases: PokemonUseCases
): ViewModel() {

    private val _state = mutableStateOf(PokemonListState())
    val state: State<PokemonListState> = _state


    val pokemonItemPagingFlow = pokemonUseCases.getPokemonListUseCase()
        .cachedIn(viewModelScope)
}