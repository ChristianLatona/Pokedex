package com.example.pokedex.data.responses

import com.squareup.moshi.Json

data class GenerationI(
    @Json(name = "red-blue") val redBlue: RedBlue,
    val yellow: Yellow
)