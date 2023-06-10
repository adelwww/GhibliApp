package com.example.ghibliapp.presentation.model

import com.example.ghibliapp.domain.model.FilmModel

data class FilmModelUI(
    val title: String,
    val original_title: String,
    val director: String,
    val producer: String,
    val description: String,
    val image: String
)
fun FilmModel.toUI() = FilmModelUI(title,original_title,director,producer,description,image)