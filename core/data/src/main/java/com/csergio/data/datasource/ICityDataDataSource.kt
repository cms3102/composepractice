package com.csergio.data.datasource

import com.csergio.network.model.CityData
import kotlinx.coroutines.flow.Flow

interface ICityDataDataSource {

    suspend fun getCityData(): Flow<List<CityData>>

}