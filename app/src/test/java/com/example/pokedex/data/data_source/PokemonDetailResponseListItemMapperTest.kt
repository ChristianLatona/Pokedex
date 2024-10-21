package com.example.pokedex.data.data_source

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import com.example.pokedex.data.responses.Result

class PokemonDetailResponseListItemMapperTest {

    private lateinit var result: Result

    @Before
    fun setUp() {
        result = Result(
            name = "Charmender",
            url = "https://pokeapi.co/api/v2/pokemon/4/"
        )
    }

    @Test
    fun `parsing PokemonList response to PokemonEntity, correct`() = runBlocking {
        assertThat(result.toPokemonEntity().id).isEqualTo(4)
        assertThat(result.toPokemonEntity().imageUrl).isEqualTo(PokemonApi.BASE_IMAGE_URL + 4 + ".png")
    }
}