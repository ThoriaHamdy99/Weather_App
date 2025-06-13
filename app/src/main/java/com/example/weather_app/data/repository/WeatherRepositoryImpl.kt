package com.example.weather_app.data.repository

import com.example.weather_app.data.datasource.remote.weather.WeatherDataSource
import com.example.weather_app.data.mapper.toDomain
import com.example.weather_app.domain.exceptions.NoWeatherFoundException
import com.example.weather_app.domain.model.LocationModel
import com.example.weather_app.domain.model.WeatherForecast
import com.example.weather_app.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource,
) : WeatherRepository, BaseRepository() {
    override suspend fun getWeather(locationModel: LocationModel): WeatherForecast =
        tryCatch(
            onSuccess = {
                weatherDataSource.getWeather(locationModel)?.toDomain()
                    ?: throw NoWeatherFoundException()
            },
            onFailure = { throwable ->
                throwable.printStackTrace()
                throw NoWeatherFoundException()
            }
        )
}


