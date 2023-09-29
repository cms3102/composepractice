package com.csergio.domain.datasource

import com.csergio.domain.entity.TourData

interface ITourDataSource {

    suspend fun getTourData(): Result<List<TourData>>

}