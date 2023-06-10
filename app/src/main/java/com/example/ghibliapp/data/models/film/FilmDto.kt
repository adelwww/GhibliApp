package com.example.ghibliapp.data.models.film

import com.example.ghibliapp.domain.model.FilmModel
import com.google.gson.annotations.SerializedName


data class FilmDto(

    @SerializedName("title")
    val title: String,

    @SerializedName("originalTitle")
    val originalTitle: String,

    @SerializedName("director")
    val director: String,

    @SerializedName("producer")
    val producer: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("image")
    val image: String
)
fun FilmDto.toDomain() = FilmModel(title,originalTitle,director,producer,description,image)
