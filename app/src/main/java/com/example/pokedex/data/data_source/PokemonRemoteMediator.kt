package com.example.pokedex.data.data_source

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.pokedex.data.data_source.local.PokemonDatabase
import com.example.pokedex.data.data_source.local.PokemonEntity
import kotlinx.coroutines.delay
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonDb: PokemonDatabase
): RemoteMediator<Int, PokemonEntity>() {


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntity>
    ): MediatorResult { // ogni volta che raggiungiamo la fine della pagina, la funzione load viene chiamata e facciamo un altra chiamata alla pagina successiva

        state.pages.map { Log.d("RemoteMediator", (it.data+it.nextKey).toString())  }

        val page = when(loadType) {  // questo serve solo a capire a che pagina siamo
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return MediatorResult.Success(
                endOfPaginationReached = true
            )
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) {
                    return MediatorResult.Success(endOfPaginationReached = true)
                } else {
                    lastItem.id / state.config.pageSize
                }
            }
        }

        return try {

            val pokemonList = pokemonApi.getPokemonList(
                limit = state.config.pageSize,
                offset = page * state.config.pageSize
            )

            pokemonDb.withTransaction { // coroutine di room, tutte le chiamate riescono o vengono annullate
                if (loadType == LoadType.REFRESH) {
                    pokemonDb.dao.clearAll()
                }
                val pokemonEntities = pokemonList.results.map { it.toPokemonEntity() }
                pokemonDb.dao.upsertAll(pokemonEntities)
                pokemonDb.dao.pagingSource().invalidate()
            }

            return MediatorResult.Success(
                endOfPaginationReached = pokemonList.results.isEmpty()
            )

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}