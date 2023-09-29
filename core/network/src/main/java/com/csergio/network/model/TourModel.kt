package com.csergio.network.model

import kotlinx.serialization.Serializable

@Serializable
data class TourModel(
    val id: Int,
    val title: String,
    val image: String,
    val description: String
)