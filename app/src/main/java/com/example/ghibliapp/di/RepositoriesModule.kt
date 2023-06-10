package com.example.ghibliapp.di

import com.example.ghibliapp.data.repository.FilmRepositoryImpl
import com.example.ghibliapp.domain.repositories.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun providePokemonRepository(repositoryImpl: FilmRepositoryImpl): FilmRepository
}