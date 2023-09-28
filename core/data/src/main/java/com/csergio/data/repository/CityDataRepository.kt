package com.csergio.data.repository

import com.csergio.domain.datasource.ICityDataDataSource
import com.csergio.domain.entity.CityData
import com.csergio.domain.repository.ICityDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityDataRepository @Inject constructor(
//    private val cityDataDataSource: ICityDataDataSource
) : ICityDataRepository {

    override suspend fun getCityData(): Result<List<CityData>> {
//        return cityDataDataSource.getCityData()
        return Result.success(emptyList())
    }

}