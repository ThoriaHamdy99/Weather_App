package com.example.weather_app.data.datasource.remote.weather

import com.example.weather_app.data.datasource.remote.apiservice.HttpClientProvider
import com.example.weather_app.data.dto.WeatherResponse
import com.example.weather_app.domain.model.LocationModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class WeatherDataSourceImpl(
    private val httpClientProvider: HttpClientProvider,
    private val weatherLink: String
) : WeatherDataSource {
    override suspend fun getWeather(locationModel: LocationModel): WeatherResponse? {
        return httpClientProvider.createHttpClient(weatherLink).get("forecast") {
            parameter("latitude", locationModel.latitude)
            parameter("longitude", locationModel.longitude)
            parameter("hourly", "time,temperature_2m,weather_code")
            parameter("daily", "temperature_2m_max,temperature_2m_min,weathercode")
            parameter(
                "current",
                "temperature_2m,wind_speed_10m,relative_humidity_2m,precipitation_probability,uv_index,pressure_msl,is_day,weather_code,apparent_temperature"
            )
            parameter("forecast_days", "8")
            parameter("timezone", "auto")
        }.body<WeatherResponse?>()
    }
    /*
        https://api.open-meteo.com/v1/forecast?latitude=28.3&longitude=30&daily=temperature_2m_max,temperature_2m_min,weather_code&hourly=temperature_2m&current=temperature_2m,wind_speed_10m,relative_humidity_2m,precipitation_probability,uv_index,pressure_msl,is_day,weather_code,apparent_temperature&forecast_days=8&timezone=auto

        */
}