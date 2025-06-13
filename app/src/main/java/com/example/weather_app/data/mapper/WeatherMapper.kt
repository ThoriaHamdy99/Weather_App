package com.example.weather_app.data.mapper

import com.example.weather_app.data.dto.WeatherResponse
import com.example.weather_app.domain.model.CurrentWeather
import com.example.weather_app.domain.model.DailyWeather
import com.example.weather_app.domain.model.HourlyWeather
import com.example.weather_app.domain.model.WeatherForecast

fun WeatherResponse.toDomain(): WeatherForecast {
    val hourlyForecast = hourly.time.mapIndexed { index, time ->
        HourlyWeather(
            time = time,
            temperature = hourly.temperature.getOrNull(index) ?: 0.0,
            weatherCode = hourly.weatherCode.getOrNull(index) ?: 0
        )
    }

    val dailyForecast = daily.time.mapIndexed { index, date ->
        DailyWeather(
            date = date,
            maxTemp = daily.maxTemperature.getOrNull(index) ?: 0.0,
            minTemp = daily.minTemperature.getOrNull(index) ?: 0.0,
            weatherCode = daily.weatherCode.getOrNull(index) ?: 0
        )
    }

    val currentWeather = CurrentWeather(
        time = currentWeather.time,
        temperature = currentWeather.temperature,
        feelsLike = currentWeather.apparentTemperature,
        windSpeed = currentWeather.windSpeed,
        humidity = currentWeather.humidity,
        rainProbability = currentWeather.precipitation,
        uvIndex = currentWeather.uvIndex,
        pressure = currentWeather.pressure,
        isDay = currentWeather.isDay == 1.0,
        weatherCode = currentWeather.weatherCode
    )

    return WeatherForecast(
        cityName = timezone.split("/")[0],
        current = currentWeather,
        hourly = hourlyForecast,
        daily = dailyForecast
    )
}
