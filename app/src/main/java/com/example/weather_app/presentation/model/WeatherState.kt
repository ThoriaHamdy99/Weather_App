package com.example.weather_app.presentation.model

import com.example.weather_app.R

enum class WeatherState(
    val state: String,
    private val code: Int,
    val dayImageResourceId: Int,
    val nightImageResourceId: Int
) {
    CLEAR_SKY("Clear sky", 0, R.drawable.day_clear_sky, R.drawable.night_clear_sky),
    MAINLY_CLEAR("Mainly clear", 1, R.drawable.day_mainly_clear, R.drawable.night_mainly_clear),
    PARTLY_CLOUDY("Partly cloudy", 2, R.drawable.day_partly_cloudy, R.drawable.night_partly_cloudy),
    OVERCAST("Overcast", 3, R.drawable.day_overcast, R.drawable.night_overcast),
    FOG("Fog", 45, R.drawable.day_fog, R.drawable.night_fog),
    DEPOSITING_RIME_FOG(
        "Depositing rime fog",
        48,
        R.drawable.day_depositing_rime_fog,
        R.drawable.night_depositing_rime_fog
    ),
    LIGHT_DRIZZLE(
        "Light drizzle",
        51,
        R.drawable.day_drizzle_light,
        R.drawable.night_drizzle_light
    ),
    MODERATE_DRIZZLE(
        "Moderate drizzle",
        53,
        R.drawable.day_drizzle_moderate,
        R.drawable.day_drizzle_moderate
    ),
    DENSE_INTENSITY_DRIZZLE(
        "Dense intensity drizzle",
        55,
        R.drawable.day_drizzle_intensity,
        R.drawable.night_drizzle_intensity
    ),

    LIGHT_FREEZING_DRIZZLE(
        "Light freezing drizzle",
        56,
        R.drawable.day_freezing_drizzle_light,
        R.drawable.night_freezing_drizzle_light
    ),
    DENSE_INTENSITY_FREEZING_DRIZZLE(
        "Dense intensity freezing drizzle",
        57,
        R.drawable.day_freezing_drizzle_intensity,
        R.drawable.night_freezing_drizzle_intensity
    ),
    SLIGHT_RAIN(
        "Slight rain",
        61,
        R.drawable.day_rain_slight,
        R.drawable.night_rain_slight
    ),

    MODERATE_RAIN(
        "Moderate rain",
        63,
        R.drawable.day_rain_moderate,
        R.drawable.night_rain_moderate
    ),
    HEAVY_INTENSITY_RAIN(
        "Heavy intensity rain",
        65,
        R.drawable.day_rain_intensity,
        R.drawable.night_rain_intensity
    ),
    LIGHT_FREEZING_RAIN(
        "Light freezing rain",
        66,
        R.drawable.day_freezing_heavy,
        R.drawable.night_freezing_light
    ),
    HEAVY_INTENSITY_FREEZING_RAIN(
        "Heavy intensity freezing rain",
        67,
        R.drawable.day_freezing_loght,
        R.drawable.night_freezing_heavy
    ),
    SLIGHT_SNOW_FALL(
        "Slight snow fall",
        71,
        R.drawable.day_snow_fall_light,
        R.drawable.night_snow_fall_light
    ),

    MODERATE_SNOW_FALL(
        "Moderate snow fall",
        73,
        R.drawable.day_snow_fall_moderate,
        R.drawable.night_snow_fall_moderate
    ),
    HEAVY_INTENSITY_SNOW_FALL(
        "Heavy intensity snow fall",
        75,
        R.drawable.day_snow_fall_intensity,
        R.drawable.night_snow_fall_intensity
    ),
    SNOW_GRAINS(
        "Snow grains",
        77,
        R.drawable.day_snow_grains,
        R.drawable.night_snow_grains
    ),
    SLIGHT_RAIN_SHOWERS(
        "Slight rain showers",
        80,
        R.drawable.day_rain_shower_slight,
        R.drawable.night_rain_shower_slight
    ),

    MODERATE_RAIN_SHOWERS(
        "Moderate rain showers",
        81,
        R.drawable.day_rain_shower_moderate,
        R.drawable.night_rain_shower_moderate
    ),
    VIOLENT_RAIN_SHOWERS(
        "Violent rain showers",
        82,
        R.drawable.day_rain_shower_violent,
        R.drawable.night_rain_shower_violent
    ),
    SLIGHT_SNOW_SHOWERS(
        "Slight snow showers",
        85,
        R.drawable.day_snow_shower_slight,
        R.drawable.night_snow_shower_slight
    ),
    HEAVY_SNOW_SHOWERS(
        "Heavy snow showers",
        86,
        R.drawable.day_snow_shower_heavy,
        R.drawable.night_snow_shower_heavy
    ),
    SLIGHT_OR_MODERATE_THUNDERSTORM(
        "Slight or moderate thunderstorm",
        95,
        R.drawable.day_thunderstrom_slight_or_moderate,
        R.drawable.night_thunderstrom_slight_or_moderate
    ),
    SLIGHT_HAIL_THUNDERSTORM(
        "Slight hail thunderstorm",
        96,
        R.drawable.day_thunderstrom_with_slight_hail,
        R.drawable.night_thunderstrom_with_slight_hail
    ),
    HEAVY_HAIL_THUNDERSTORM(
        "Heavy hail thunderstorm",
        99,
        R.drawable.day_thunderstrom_with_heavy_hail,
        R.drawable.night_thunderstrom_with_heavy_hail
    );

    fun getWeatherState(code: Int): WeatherState? {
        return entries.find { weatherState ->
            weatherState.code == code
        }
    }
}


