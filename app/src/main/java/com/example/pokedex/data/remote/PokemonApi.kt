package com.example.pokedex.data.remote

import com.example.pokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Query


interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList


    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}