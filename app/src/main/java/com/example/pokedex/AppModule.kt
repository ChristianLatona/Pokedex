package com.example.pokedex

import com.example.pokedex.data.data_source.PokemonApi
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.data.repository.PokemonRepositoryImpl
import com.example.pokedex.domain.use_case.GetPokemonInfoUseCase
import com.example.pokedex.domain.use_case.GetPokemonListUseCase
import com.example.pokedex.domain.use_case.PokemonUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .baseUrl(PokemonApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providePokemonRepository(
        pokemonApi: PokemonApi
    ): PokemonRepository = PokemonRepositoryImpl(pokemonApi)

    @Provides
    @Singleton
    fun providePokemonUseCases(
        repository: PokemonRepository
    ) = PokemonUseCases(
        getPokemonListUseCase = GetPokemonListUseCase(repository),
        getPokemonInfoUseCase = GetPokemonInfoUseCase(repository)
    )
}