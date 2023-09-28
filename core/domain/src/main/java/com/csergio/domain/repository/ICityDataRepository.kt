package com.csergio.domain.repository

import com.csergio.domain.entity.CityData

interface ICityDataRepository {

    suspend fun getCityData() : Result<List<CityData>>

}