package com.example.weather_app.presentation.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weather_app.domain.model.DailyWeather
import com.example.weather_app.domain.model.HourlyWeather
import com.example.weather_app.domain.model.WeatherForecast
import com.example.weather_app.presentation.model.CurrentTemperatureUIModel
import com.example.weather_app.presentation.model.CurrentWeatherDetails
import com.example.weather_app.presentation.model.CurrentWeatherStatus
import com.example.weather_app.presentation.model.DailyWeatherUiModel
import com.example.weather_app.presentation.model.HourlyWeatherUiModel
import com.example.weather_app.presentation.model.WeatherState
import com.example.weather_app.presentation.model.WeatherUiModel
import com.example.weather_app.presentation.utils.getWeekday

@RequiresApi(Build.VERSION_CODES.O)
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
        hourlyWeather = hourly.map {
            it.mapToUi(!current.isDay)
        },
        dailyWeather = daily.mapToUi(!current.isDay)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun List<DailyWeather>.mapToUi(isNightMode: Boolean): List<DailyWeatherUiModel> {
    val dailyWeatherList = this.toMutableList()
    dailyWeatherList.removeAt(0)
    return dailyWeatherList.map { dailyWeather ->
        DailyWeatherUiModel(
            dailyWeather.date.getWeekday(),
            maxTemp = dailyWeather.maxTemp.toInt().toString(),
            minTemp = dailyWeather.minTemp.toInt().toString(),
            weatherIcon = if (isNightMode) {
                WeatherState.getWeatherState(dailyWeather.weatherCode).nightImageResourceId
            } else WeatherState.getWeatherState(dailyWeather.weatherCode).dayImageResourceId,
        )
    }
}

fun HourlyWeather.mapToUi(isNightMode: Boolean): HourlyWeatherUiModel {
    val weatherState = WeatherState.getWeatherState(this.weatherCode)
    return HourlyWeatherUiModel(
        this.time.split("T")[1],
        temperature = this.temperature.toInt().toString(),
        weatherIcon = if (isNightMode) {
            weatherState.nightImageResourceId
        } else weatherState.dayImageResourceId,
    )
}