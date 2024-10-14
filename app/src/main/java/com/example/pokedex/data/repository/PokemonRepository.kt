package com.example.pokedex.data.repository

import com.example.pokedex.data.responses.Pokemon
import com.example.pokedex.data.responses.PokemonList

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): PokemonList
    suspend fun getPokemonInfo(name: String): Pokemon
}