package com.example.ghibliapp.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ghibliapp.domain.either.Either
import com.example.ghibliapp.domain.model.FilmModel
import com.example.ghibliapp.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun <T, S> Flow<Either<String, T>>.collectRequest(
        state: MutableStateFlow<UIState<S>>,
        mapData: (T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mapData(it.value))
                }
            }
        }
    }
}