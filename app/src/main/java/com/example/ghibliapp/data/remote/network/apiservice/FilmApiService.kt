package com.example.ghibliapp.data.remote.network.apiservice

import com.example.ghibliapp.data.models.film.FilmDto
import com.example.ghibliapp.data.models.film.FilmResponseDto
import retrofit2.http.GET

interface FilmApiService {

    @GET("/films")
    suspend fun fetchFilm(
    ) : FilmResponseDto<FilmDto>
}