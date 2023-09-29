package com.csergio.tour.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csergio.tour.TourState
import com.csergio.domain.usecase.TourUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TourViewModel @Inject constructor(
    private val tourUseCase: TourUseCase
) : ViewModel() {

    private val _tourState: MutableStateFlow<TourState> = MutableStateFlow(TourState.Loading)
    val tourState: StateFlow<TourState> = _tourState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _tourState.value = TourState.Loading
            val data = tourUseCase()
            _tourState.value = if (data.isSuccess) {
                TourState.Success(data.getOrDefault(emptyList()))
            } else {
                TourState.Failure(data.exceptionOrNull() ?: Throwable("Unknown Error"))
            }
        }
    }

}