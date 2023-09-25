package com.csergio.domain.datasource

import com.csergio.domain.entity.CityData
import kotlinx.coroutines.flow.Flow

interface ICityDataDataSource {

    suspend fun getCityData(): Flow<Result<List<CityData>>>

}