package com.example.weather_app.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    @SerialName("time") val time: String,
    @SerialName("temperature_2m") val temperature: Double,
    @SerialName("wind_speed_10m") val windSpeed: Double,
    @SerialName("relative_humidity_2m") val humidity: Double,
    @SerialName("precipitation_probability") val precipitation: Double,
    @SerialName("uv_index") val uvIndex: Double,
    @SerialName("pressure_msl") val pressure: Double,
    @SerialName("apparent_temperature") val apparentTemperature: Double,
    @SerialName("is_day") val isDay: Double,
    @SerialName("weathercode") val weatherCode: Int,
)