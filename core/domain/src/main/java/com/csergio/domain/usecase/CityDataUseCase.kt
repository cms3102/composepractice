package com.csergio.domain.usecase

import com.csergio.domain.entity.CityData
import com.csergio.domain.repository.ICityDataRepository
import javax.inject.Inject

class CityDataUseCase @Inject constructor(
    private val cityDataRepository: ICityDataRepository
) {
     suspend operator fun invoke(): Result<List<CityData>> =
        cityDataRepository.getCityData()

}