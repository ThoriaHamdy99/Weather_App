package com.example.weather_app.data.repository

import com.example.weather_app.data.datasource.remote.location.LocationDataSource
import com.example.weather_app.data.mapper.toModel
import com.example.weather_app.domain.exceptions.NoLocationFoundException
import com.example.weather_app.domain.model.LocationModel
import com.example.weather_app.domain.repository.LocationRepository

class LocationRepositoryImpl(
    private val locationDataSource: LocationDataSource
) : LocationRepository, BaseRepository() {
    override suspend fun getCurrentLocation(): LocationModel = super.tryCatch(
        onSuccess = {
            locationDataSource.getCurrentLocation().toModel()
        },
        onFailure = { throwable ->
            throwable.printStackTrace()
            throw NoLocationFoundException()
        }
    )
}