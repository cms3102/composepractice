package com.csergio.data.datasource

import com.csergio.network.api.CityDataService
import com.csergio.network.model.CityData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CityDataSource @Inject constructor(
    private val cityDataService: CityDataService
) : ICityDataDataSource {

    override suspend fun getCityData(): Flow<List<CityData>> = callbackFlow {
        val result = cityDataService.getCityData()
        send(result)
    }

}