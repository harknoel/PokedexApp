package com.hark.pokedex.di

import com.hark.pokedex.data.repository.PokemonRepositoryImpl
import com.hark.pokedex.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providePokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}
