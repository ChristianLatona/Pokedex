package com.example.pokedex.data.responses

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)