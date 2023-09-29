package com.csergio.data.datasource

import com.csergio.data.mapper.toEntity
import com.csergio.domain.datasource.ITourDataSource
import com.csergio.domain.entity.TourData
import com.csergio.network.api.TourDataService
import com.csergio.network.util.asResult
import javax.inject.Inject

class TourDataSource @Inject constructor(
    private val tourDataService: TourDataService
) : ITourDataSource {

    override suspend fun getTourData(): Result<List<TourData>> =
        tourDataService.getTourData()
            .asResult()
            .map { it.data }
            .toEntity()


}