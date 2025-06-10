package com.example.weather_app.data.datasource.remote.location

import com.example.weather_app.data.datasource.remote.apiservice.HttpClientProvider
import com.example.weather_app.data.dto.LocationDto
import io.ktor.client.call.body
import io.ktor.client.request.get

class LocationDataSourceImpl(
    private val httpClientProvider: HttpClientProvider,
    private val ipLocationLink: String,
) : LocationDataSource {

    override suspend fun getCurrentLocation(): LocationDto? {
        return httpClientProvider.createHttpClient(ipLocationLink)
            .get("json").body<LocationDto?>()
    }
}