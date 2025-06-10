package com.example.weather_app.data.datasource.remote.weather

import com.example.weather_app.data.dto.WeatherResponse
import com.example.weather_app.domain.model.LocationModel

interface WeatherDataSource {
    suspend fun getWeather(locationModel: LocationModel): WeatherResponse?
}