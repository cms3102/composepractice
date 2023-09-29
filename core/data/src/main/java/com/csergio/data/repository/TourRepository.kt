package com.csergio.data.repository

import com.csergio.domain.datasource.ITourDataSource
import com.csergio.domain.entity.TourData
import com.csergio.domain.repository.ITourRepository
import javax.inject.Inject

class TourRepository @Inject constructor(
    private val tourDataSource: ITourDataSource
) : ITourRepository {

    override suspend fun getTourData(): Result<List<TourData>> {
        return tourDataSource.getTourData()
    }

}