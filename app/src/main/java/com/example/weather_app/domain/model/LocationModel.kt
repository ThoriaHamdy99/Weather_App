package com.example.weather_app.domain.model

data class LocationModel(
    val latitude: Double?,
    val longitude: Double?,
    val city: String?,
    val country: String?,
    val countryCode: String?,
    val timezone: String?
)