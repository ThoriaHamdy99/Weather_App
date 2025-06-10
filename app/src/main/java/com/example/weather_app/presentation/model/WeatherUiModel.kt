package com.example.weather_app.presentation.model

import com.example.weather_app.domain.model.DailyWeather
import com.example.weather_app.domain.model.HourlyWeather

data class WeatherUiModel(
    val isNightMode: Boolean,
    val countryName: String,
    val currentTemperatureUiModel: CurrentTemperatureUIModel,
    val currentWeatherDetails: List<CurrentWeatherDetails>,
    val hourlyWeather: List<HourlyWeather>,
    val dailyWeather: List<DailyWeather>
)
