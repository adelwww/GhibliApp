package com.example.ghibliapp.data.remote.network.retrofit

import com.example.ghibliapp.data.remote.network.apiservice.FilmApiService
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun provideFilmApiService() = provideRetrofit.create(FilmApiService::class.java)
}