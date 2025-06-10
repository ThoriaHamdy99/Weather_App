package com.example.weather_app.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    @SerialName("lat") val latitude: Double?,
    @SerialName("lon") val longitude: Double?,
    @SerialName("city") val city: String?,
    @SerialName("country") val country: String?
)
