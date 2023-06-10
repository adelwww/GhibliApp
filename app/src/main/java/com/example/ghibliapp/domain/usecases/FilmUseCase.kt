package com.example.ghibliapp.domain.usecases

import com.example.ghibliapp.domain.repositories.FilmRepository
import javax.inject.Inject

class FilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {

    operator fun invoke() = repository.fetchFilm()

}