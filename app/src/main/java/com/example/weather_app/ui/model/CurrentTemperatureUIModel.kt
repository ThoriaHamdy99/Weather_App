package com.example.weather_app.ui.model

data class CurrentTemperatureUIModel(
    val weatherState: WeatherState,
    val temperature: String,
    val minTemp: String,
    val maxTemp: String
)
