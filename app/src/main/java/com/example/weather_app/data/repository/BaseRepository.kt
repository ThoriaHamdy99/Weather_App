package com.example.weather_app.data.repository

open class BaseRepository {
    suspend fun <T> tryCatch(
        onSuccess: suspend () -> T,
        onFailure: (Exception) -> T
    ): T {
        return try {
            onSuccess()
        } catch (e: Exception) {
            onFailure(e)
        }
    }
}