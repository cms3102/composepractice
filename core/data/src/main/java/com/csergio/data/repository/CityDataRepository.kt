package com.csergio.data.repository

import com.csergio.domain.entity.CityData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityDataRepository @Inject constructor(
    private val cityDataDataSource: com.csergio.domain.datasource.ICityDataDataSource
) : com.csergio.domain.repository.ICityDataRepository {

    override suspend fun getCityData(): Flow<List<CityData>> {
        return cityDataDataSource.getCityData()
    }

}