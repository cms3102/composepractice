package com.csergio.citydata

import com.csergio.domain.entity.CityData

sealed class CityDataState {
    object Loading : CityDataState()
    data class Success(val data: List<CityData>) : CityDataState()
    data class Failure(val error: Throwable) : CityDataState()
}