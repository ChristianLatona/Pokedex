package com.example.pokedex.data.responses

import com.squareup.moshi.Json

data class GenerationV(
    @Json(name = "black-white") val blackWhite: BlackWhite
)