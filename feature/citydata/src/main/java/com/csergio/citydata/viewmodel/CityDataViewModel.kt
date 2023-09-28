package com.csergio.citydata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csergio.citydata.CityDataState
import com.csergio.domain.usecase.CityDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityDataViewModel @Inject constructor(
    private val cityDataUseCase: CityDataUseCase
) : ViewModel() {

    private val _cityDataState: MutableStateFlow<CityDataState> = MutableStateFlow(CityDataState.Loading)
    val cityDataState: StateFlow<CityDataState> = _cityDataState

    fun fetchData() {
        viewModelScope.launch {
            _cityDataState.value = CityDataState.Loading
//            val data = cityDataUseCase()
//            _cityDataState.value = if (data.isSuccess) {
//                CityDataState.Success(data.getOrDefault(emptyList()))
//            } else {
//                CityDataState.Failure(data.exceptionOrNull() ?: Throwable("Unknown Error"))
//            }
        }
    }

}