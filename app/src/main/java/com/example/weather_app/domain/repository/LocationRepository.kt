package com.example.weather_app.domain.repository

import com.example.weather_app.domain.model.LocationModel

interface LocationRepository {
    suspend fun getCurrentLocation(): LocationModel
}