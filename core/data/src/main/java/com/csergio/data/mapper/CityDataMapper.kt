package com.csergio.data.mapper

import com.csergio.domain.entity.CityData
import com.csergio.network.model.CityDataModel

internal fun Result<List<CityDataModel>>.toEntity(): Result<List<CityData>> {
    return map { list ->
        list.map { model ->
            model.toEntity()
        }
    }
}

internal fun CityDataModel.toEntity(): CityData {
    return CityData(
        title = title,
        image = image,
        description = description
    )
}