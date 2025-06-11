package com.example.weather_app.domain.repository

import com.example.weather_app.domain.model.LocationModel
import com.example.weather_app.domain.model.WeatherForecast

interface WeatherRepository {
    suspend fun getWeather(locationModel: LocationModel): WeatherForecast
}