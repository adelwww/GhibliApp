package com.example.ghibliapp.di

import com.example.ghibliapp.data.remote.network.retrofit.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideFilmApiServices(networkClient: NetworkClient) =
        networkClient.provideFilmApiService()

}