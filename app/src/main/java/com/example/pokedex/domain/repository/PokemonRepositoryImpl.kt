package com.example.pokedex.domain.repository

import com.example.pokedex.data.remote.PokemonApi
import com.example.pokedex.data.remote.responses.PokemonList
import com.example.pokedex.data.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
): PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonList {
        return api.getPokemonList(limit, offset)
    }
}