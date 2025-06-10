package com.example.weather_app.domain.model

data class WeatherForecast(
    var cityName: String,
    val current: CurrentWeather,
    val hourly: List<HourlyWeather>,
    val daily: List<DailyWeather>
)

data class CurrentWeather(
    val time: String,
    val temperature: Double,
    val feelsLike: Double,
    val windSpeed: Double,
    val humidity: Double,
    val rainProbability: Double,
    val uvIndex: Double,
    val pressure: Double,
    val isDay: Boolean,
    val weatherCode: Int
)

data class HourlyWeather(
    val time: String,
    val temperature: Double,
    val weatherCode: Int
)

data class DailyWeather(
    val date: String,
    val maxTemp: Double,
    val minTemp: Double,
    val weatherCode: Int
)