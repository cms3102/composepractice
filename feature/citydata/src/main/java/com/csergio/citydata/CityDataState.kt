package com.csergio.citydata

import com.csergio.domain.entity.CityData

sealed class CityDataState {
    object Loading : CityDataState()
    class Success(val data: List<CityData>) : CityDataState()
    class Failure(val error: Throwable) : CityDataState()
}