package com.example.pokedex.data.data_source.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface PokemonDao {
    // per fare il caching, generalmente vuoi sempre il clear all per fare il refresh della pagina (serve ricaricare dall'api in genere anche se qui tipo non serve)
    // il paging source ovviamente gestisce tutto
    // l'upsert all è indispensabile per mettere i dati dall'api al database

    @Upsert
    suspend fun upsertAll(pokemonEntities: List<PokemonEntity>)

    @Query("SELECT * FROM pokemonentity")
    fun pagingSource(): PagingSource<Int, PokemonEntity>

    @Query("SELECT count(*) FROM pokemonentity")
    fun getCount(): Int

    @Query("DELETE FROM pokemonentity") // con il delete non posso togliere tutti i record, devo per forza passare un record nei parametri
    suspend fun clearAll()
}