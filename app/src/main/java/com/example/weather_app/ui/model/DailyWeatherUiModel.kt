package com.example.weather_app.ui.model

import androidx.annotation.DrawableRes

data class DailyWeatherUiModel(
    val dayOfWeek: String,
    val maxTemp: String,
    val minTemp: String,
    @DrawableRes val weatherIcon: Int
)
