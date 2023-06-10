package com.example.ghibliapp.data.models.film

import com.example.ghibliapp.domain.model.FilmResponse
import com.google.gson.annotations.SerializedName

data class FilmResponseDto<T>(
    @SerializedName("results")
    val results: ArrayList<T>
)
fun <T> FilmResponseDto<T>.toDomain() = FilmResponse<T>(results)