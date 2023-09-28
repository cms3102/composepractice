package com.csergio.data.datasource

import com.csergio.data.mapper.toEntity
import com.csergio.domain.datasource.ICityDataDataSource
import com.csergio.domain.entity.CityData
import com.csergio.network.api.CityDataService
import com.csergio.network.util.asResult
import javax.inject.Inject

class CityDataSource @Inject constructor(
    private val cityDataService: CityDataService
) : ICityDataDataSource {

    override suspend fun getCityData(): Result<List<CityData>> =
        cityDataService.getCityData()
            .asResult()
            .toEntity()


}