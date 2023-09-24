package com.csergio.data.repository

import com.csergio.data.datasource.ICityDataDataSource
import com.csergio.network.model.CityData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityDataRepository @Inject constructor(
    private val cityDataDataSource: ICityDataDataSource
) : ICityDataRepository {

    override suspend fun getCityData(): Flow<List<CityData>> {
        return cityDataDataSource.getCityData()
    }

}