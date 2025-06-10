package com.example.weather_app.presentation.model

data class WeatherDetails(
    val title: String,
    val value: String,
    val measurement: String,
    val iconResourceId: Int
)
