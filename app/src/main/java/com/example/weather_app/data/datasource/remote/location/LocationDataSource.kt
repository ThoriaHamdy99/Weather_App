package com.example.weather_app.data.datasource.remote.location

import com.example.weather_app.data.dto.LocationDto

interface LocationDataSource {
    suspend fun getCurrentLocation(): LocationDto
}