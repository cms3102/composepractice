package com.csergio.data.repository

import com.csergio.network.model.CityData
import kotlinx.coroutines.flow.Flow

interface ICityDataRepository {

    suspend fun getCityData() : Flow<List<CityData>>

}