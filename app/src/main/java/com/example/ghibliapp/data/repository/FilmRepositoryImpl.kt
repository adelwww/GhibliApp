package com.example.ghibliapp.data.repository

import com.example.ghibliapp.data.models.film.toDomain
import com.example.ghibliapp.domain.either.Either
import com.example.ghibliapp.data.remote.network.apiservice.FilmApiService
import com.example.ghibliapp.data.repository.base.BaseRepository
import com.example.ghibliapp.domain.model.FilmModel
import com.example.ghibliapp.domain.repositories.FilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val apiService: FilmApiService
) : BaseRepository(), FilmRepository {

    override fun fetchFilm(): Flow<Either<String, List<FilmModel>>> = doRequest {
        apiService.fetchFilm().results.map { it.toDomain()}
    }



}