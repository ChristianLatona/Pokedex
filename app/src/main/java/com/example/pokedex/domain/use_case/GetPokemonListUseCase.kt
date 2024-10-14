package com.example.pokedex.domain.use_case

import com.example.pokedex.data.repository.PokemonRepository


class GetPokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) {

}