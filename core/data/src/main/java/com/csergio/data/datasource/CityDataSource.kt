package com.csergio.data.datasource

import com.csergio.data.mapper.toEntity
import com.csergio.domain.datasource.ICityDataDataSource
import com.csergio.domain.entity.CityData
import com.csergio.network.api.CityDataService
import com.csergio.network.util.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CityDataSource @Inject constructor(
    private val cityDataService: CityDataService
) : ICityDataDataSource {

    override suspend fun getCityData(): Flow<Result<List<CityData>>> = flow {
        val result = cityDataService.getCityData()
            .asResult()
            .toEntity()

        emit(result)
    }

}