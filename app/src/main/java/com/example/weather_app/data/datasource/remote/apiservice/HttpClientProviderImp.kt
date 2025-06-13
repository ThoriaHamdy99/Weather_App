package com.example.weather_app.data.datasource.remote.apiservice

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientProviderImp : HttpClientProvider {
    override fun createHttpClient(urlString: String): HttpClient {
        return HttpClient(CIO)
        {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                url(urlString)
            }

        }
    }
}