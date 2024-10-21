package com.example.pokedex.domain.use_case

import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.data.responses.PokemonResponse
import com.example.pokedex.presentation.models.PokemonDetail

class GetPokemonDetail(
    private val repository: PokemonRepository
) {

    suspend operator fun invoke(
        name: String
    ): PokemonDetail {

        return repository.getPokemonInfo(name).toPokemon()
    }

    private fun PokemonResponse.toPokemon(): PokemonDetail {
        val baseStats = stats.associate { stat ->
            stat.stat.name to stat.base_stat
        }
        var type2: String? = null
        if (types.size == 2) {
            type2 = types[1].type.name
        }

        return PokemonDetail(
            pokemonName = name,
            type1 = types.first().type.name,
            type2 = type2,
            weight = weight,
            height = height,
            baseStats = baseStats,
            imageUrl = sprites.front_default
        )
    }
}