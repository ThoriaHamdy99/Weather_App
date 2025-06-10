package com.example.weather_app.presentation.model

data class CurrentTemperatureUIModel(
    val weatherState: WeatherState,
    val temperature: String,
    val minTemp: String,
    val maxTemp: String
)
