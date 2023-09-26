package com.csergio.domain.usecase

import com.csergio.domain.datasource.ICityDataDataSource
import com.csergio.domain.entity.CityData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityDataUseCase @Inject constructor(
    private val cityDataDataSource: ICityDataDataSource
) : ICityDataDataSource {
    override suspend fun getCityData(): Flow<Result<List<CityData>>> =
        cityDataDataSource.getCityData()

}