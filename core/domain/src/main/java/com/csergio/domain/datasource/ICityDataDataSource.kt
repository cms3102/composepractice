package com.csergio.domain.datasource

import com.csergio.domain.entity.CityData

interface ICityDataDataSource {

    suspend fun getCityData(): Result<List<CityData>>

}