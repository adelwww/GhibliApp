package com.example.ghibliapp.domain.repositories

import com.example.ghibliapp.domain.either.Either
import com.example.ghibliapp.domain.model.FilmModel
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    fun fetchFilm() : Flow<Either<String, List<FilmModel>>>
}