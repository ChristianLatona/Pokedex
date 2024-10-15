package com.example.pokedex.data.responses

import com.squareup.moshi.Json

data class Other(
    val dream_world: DreamWorld,
    val home: Home,
    @Json(name = "official-artwork") val officialArtwork: OfficialArtwork,
    val showdown: Showdown
)