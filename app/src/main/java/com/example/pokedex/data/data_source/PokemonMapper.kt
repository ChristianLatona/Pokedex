package com.example.pokedex.data.data_source

import com.example.pokedex.data.data_source.local.PokemonEntity
import com.example.pokedex.data.responses.Result
import com.example.pokedex.presentation.models.PokemonListItem

fun Result.toPokemonEntity(): PokemonEntity {
    val id = url
        .replace("https://pokeapi.co/api/v2/pokemon/", "")
        .replace("/", "")
        .toInt()

    val imageUrl = PokemonApi.BASE_IMAGE_URL + id + ".png"

    return PokemonEntity(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}

fun PokemonEntity.toPokemon(): PokemonListItem =
    PokemonListItem(
        pokemonName = name,
        imageUrl = imageUrl
    )