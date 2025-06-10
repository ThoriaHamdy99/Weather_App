package com.example.weather_app.presentation.model

import com.example.weather_app.R

enum class CurrentWeatherStatus(
    val statusName: String,
    val iconResId: Int,
    val measureTool: String
) {
    WIND("Wind", R.drawable.fast_wind_icon, "KM/h"),
    HUMIDITY("Humidity", R.drawable.humidity_icon, "%"),
    RAIN("Rain", R.drawable.rain_icon, "%"),
    UV_INDEX("Uv Index", R.drawable.uv_icon, ""),
    PRESSURE("Pressure", R.drawable.pressure_icon, "hPa"),
    FEELS_LIKE("Feels like", R.drawable.temperature_icon, "°C"),
}