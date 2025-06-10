package com.example.weather_app.presentation.mapper

import com.example.weather_app.domain.model.WeatherForecast
import com.example.weather_app.presentation.model.CurrentTemperatureUIModel
import com.example.weather_app.presentation.model.CurrentWeatherDetails
import com.example.weather_app.presentation.model.CurrentWeatherStatus
import com.example.weather_app.presentation.model.WeatherState
import com.example.weather_app.presentation.model.WeatherUiModel

fun WeatherForecast.mapToUiModel(): WeatherUiModel {
    return WeatherUiModel(
        isNightMode = !current.isDay,
        countryName = cityName,
        currentTemperatureUiModel = CurrentTemperatureUIModel(
            weatherState = WeatherState.getWeatherState(current.weatherCode),
            temperature = current.temperature.toInt().toString(),
            minTemp = daily[0].minTemp.toInt().toString(),
            maxTemp = daily[0].maxTemp.toInt().toString()
        ),
        currentWeatherDetails = listOf(
            CurrentWeatherDetails(
                currentWeatherStatus = CurrentWeatherStatus.WIND,
                value = current.windSpeed.toInt().toString()
            ),
            CurrentWeatherDetails(
                currentWeatherStatus = CurrentWeatherStatus.HUMIDITY,
                value = current.humidity.toInt().toString()
            ),
            CurrentWeatherDetails(
                currentWeatherStatus = CurrentWeatherStatus.RAIN,
                value = current.rainProbability.toInt().toString()
            ),
            CurrentWeatherDetails(
                currentWeatherStatus = CurrentWeatherStatus.UV_INDEX,
                value = current.uvIndex.toInt().toString()
            ),
            CurrentWeatherDetails(
                currentWeatherStatus = CurrentWeatherStatus.PRESSURE,
                value = current.pressure.toInt().toString()
            ),
            CurrentWeatherDetails(
                currentWeatherStatus = CurrentWeatherStatus.FEELS_LIKE,
                value = current.feelsLike.toInt().toString()
            )
        ),
        hourlyWeather = hourly,
        dailyWeather = daily
    )
}