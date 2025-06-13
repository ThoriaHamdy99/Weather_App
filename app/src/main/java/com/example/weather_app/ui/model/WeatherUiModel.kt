package com.example.weather_app.ui.model

data class WeatherUiModel(
    val isNightMode: Boolean,
    val countryName: String,
    val currentTemperatureUiModel: CurrentTemperatureUIModel,
    val currentWeatherDetails: List<CurrentWeatherDetails>,
    val hourlyWeather: List<HourlyWeatherUiModel>,
    val dailyWeather: List<DailyWeatherUiModel>
)
