package com.csergio.tour

import com.csergio.domain.entity.TourData

sealed class TourState {
    object Loading : TourState()
    class Success(val data: List<TourData>) : TourState()
    class Failure(val error: Throwable) : TourState()
}