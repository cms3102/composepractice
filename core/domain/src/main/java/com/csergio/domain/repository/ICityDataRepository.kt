package com.csergio.domain.repository

import com.csergio.domain.entity.CityData
import kotlinx.coroutines.flow.Flow

interface ICityDataRepository {

    suspend fun getCityData() : Flow<List<CityData>>

}