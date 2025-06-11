package com.example.weather_app.ui.model

import androidx.annotation.DrawableRes

data class HourlyWeatherUiModel(
    val time: String,
    val temperature: String,
    @DrawableRes val weatherIcon: Int
)
