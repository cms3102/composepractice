package com.csergio.data.mapper

import com.csergio.domain.entity.TourData
import com.csergio.network.model.TourModel

internal fun Result<List<TourModel>>.toEntity(): Result<List<TourData>> {
    return map { list ->
        list.map { model ->
            model.toEntity()
        }
    }
}

internal fun TourModel.toEntity(): TourData {
    return TourData(
        id = id,
        title = title,
        image = image,
        description = description
    )
}