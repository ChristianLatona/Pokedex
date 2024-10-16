package com.example.pokedex.domain.use_case

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.example.pokedex.data.data_source.local.PokemonEntity
import com.example.pokedex.data.data_source.toPokemonItem
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.presentation.models.PokemonItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository,
    private val pager: Pager<Int, PokemonEntity>
) {

    operator fun invoke(): Flow<PagingData<PokemonItem>> =
        pager
            .flow
            .map { pagingData ->
                pagingData.map { it.toPokemonItem() }
            }

}