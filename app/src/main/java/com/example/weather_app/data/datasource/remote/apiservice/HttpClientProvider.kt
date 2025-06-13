package com.example.weather_app.data.datasource.remote.apiservice

import io.ktor.client.*

interface HttpClientProvider {
    fun createHttpClient(urlString: String): HttpClient
}