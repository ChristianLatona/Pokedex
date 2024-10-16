package com.example.pokedex.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PokemonEntity::class],
    version = 1
)
abstract class PokemonDatabase: RoomDatabase() {

    abstract val dao: PokemonDao
}