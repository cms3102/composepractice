package com.csergio.domain.repository

import com.csergio.domain.entity.TourData

interface ITourRepository {

    suspend fun getTourData() : Result<List<TourData>>

}