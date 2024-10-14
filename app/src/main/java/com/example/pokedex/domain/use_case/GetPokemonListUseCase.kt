package com.example.pokedex.domain.use_case

import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.data.responses.PokemonList

class GetPokemonListUseCase(
    private val repository: PokemonRepository
) {

    suspend operator fun invoke(
        limit: Int = 20,
        offset: Int = 0
    ): PokemonList {


        return repository.getPokemonList(limit, offset)
    }
}