package com.csergio.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CityDataModel(
    val title: String,
    val image: String,
    val description: String
)