package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.responses.PokemonList

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): PokemonList
}