package com.example.pokedex.data.repository

import com.example.pokedex.data.data_source.PokemonApi
import com.example.pokedex.data.responses.Pokemon
import com.example.pokedex.data.responses.PokemonList
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
): PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonList {
        return pokemonApi.getPokemonList(limit, offset)
    }

    override suspend fun getPokemonInfo(name: String): Pokemon {
        return pokemonApi.getPokemonInfo(name)
    }
}