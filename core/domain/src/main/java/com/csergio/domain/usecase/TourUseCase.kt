package com.csergio.domain.usecase

import com.csergio.domain.entity.TourData
import com.csergio.domain.repository.ITourRepository
import javax.inject.Inject

class TourUseCase @Inject constructor(
    private val tourRepository: ITourRepository
) {
     suspend operator fun invoke(): Result<List<TourData>> =
        tourRepository.getTourData()

}