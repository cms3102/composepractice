package com.csergio.domain.usecase

import com.csergio.domain.entity.CityData

interface ICtyDataUseCase {
    suspend operator fun invoke(): Result<List<CityData>>
}