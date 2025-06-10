package com.example.weather_app.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("timezone") val timezone: String,
    @SerialName("current_weather") val currentWeather: CurrentWeatherDto,
    @SerialName("hourly") val hourly: HourlyDto,
    @SerialName("daily") val daily: DailyDto
)