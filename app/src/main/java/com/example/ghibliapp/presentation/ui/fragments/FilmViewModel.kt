package com.example.ghibliapp.presentation.ui.fragments

import androidx.lifecycle.viewModelScope
import com.example.ghibliapp.presentation.state.UIState
import com.example.ghibliapp.domain.usecases.FilmUseCase
import com.example.ghibliapp.presentation.model.FilmModelUI
import com.example.ghibliapp.presentation.base.BaseViewModel
import com.example.ghibliapp.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val useCase: FilmUseCase
) : BaseViewModel() {

    private val _filmState =
        MutableStateFlow<UIState<List<FilmModelUI>>>(UIState.Loading())
    val filmState = _filmState.asStateFlow()

    init {
        fetchFilm()
    }

    private fun fetchFilm() = viewModelScope.launch {
        _filmState.value = UIState.Loading()
        useCase().collectRequest(_filmState) {
            it.map { it.toUI() }
        }
    }
}