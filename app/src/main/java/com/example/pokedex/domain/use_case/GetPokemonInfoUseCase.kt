package com.example.pokedex.domain.use_case

import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.data.responses.Pokemon

class GetPokemonInfoUseCase(
    private val repository: PokemonRepository
) {

    suspend operator fun invoke(
        name: String
    ): Pokemon {

        return repository.getPokemonInfo(name)
    }
}