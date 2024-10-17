package com.example.pokedex

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.pokedex.data.data_source.PokemonApi
import com.example.pokedex.data.data_source.PokemonRemoteMediator
import com.example.pokedex.data.data_source.local.PokemonDatabase
import com.example.pokedex.data.data_source.local.PokemonEntity
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.data.repository.PokemonRepositoryImpl
import com.example.pokedex.domain.use_case.GetPokemonInfoUseCase
import com.example.pokedex.domain.use_case.GetPokemonListUseCase
import com.example.pokedex.domain.use_case.PokemonUseCases
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi = Retrofit.Builder()
            .baseUrl(PokemonApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory()) // Aggiungi l'adattatore Kotlin
                    .build()
            ))
            .build()
            .create()

    @Provides
    @Singleton
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase = Room.databaseBuilder(
        context = context,
        klass = PokemonDatabase::class.java,
        name = "pokemon.db"
    ).build()

    @Provides
    @Singleton
    fun providePokemonRepository(
        pokemonApi: PokemonApi
    ): PokemonRepository = PokemonRepositoryImpl(pokemonApi)

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providePokemonPager(pokemonApi: PokemonApi, pokemonDatabase: PokemonDatabase): Pager<Int, PokemonEntity> {
        return Pager(
            config = PagingConfig(
                pageSize = PokemonApi.PAGE_SIZE,
                enablePlaceholders = false),
            remoteMediator = PokemonRemoteMediator(
                pokemonDb = pokemonDatabase,
                pokemonApi = pokemonApi
            ),
            pagingSourceFactory = { pokemonDatabase.dao.pagingSource() }
        )
    }

    @Provides
    @Singleton
    fun providePokemonUseCases(
        repository: PokemonRepository,
        pager: Pager<Int, PokemonEntity>
    ) = PokemonUseCases(
        getPokemonListUseCase = GetPokemonListUseCase(repository, pager),
        getPokemonInfoUseCase = GetPokemonInfoUseCase(repository)
    )
}