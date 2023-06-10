package com.example.ghibliapp.domain.model

data class FilmResponse<T>(
    val results: List<T>
)