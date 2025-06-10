package com.example.weather_app.data.mapper

import com.example.weather_app.data.dto.LocationDto
import com.example.weather_app.domain.model.LocationModel

fun LocationDto.toModel(): LocationModel {
    return LocationModel(
        latitude = this.latitude,
        longitude = this.longitude,
        city = this.city,
        country = this.country
    )
}

