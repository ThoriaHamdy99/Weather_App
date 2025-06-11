package com.example.weather_app.presentation.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.weather_app.R

enum class WeatherState(
    val state: String,
    private val code: Int,
    @DrawableRes val dayImageResourceId: Int,
    @DrawableRes val nightImageResourceId: Int,
    val dayShadowColor: Color,
    val nightShadowColor: Color,
) {
    CLEAR_SKY(
        "Clear sky", 0, R.drawable.day_clear_sky, R.drawable.night_clear_sky,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    MAINLY_CLEAR(
        "Mainly clear", 1, R.drawable.day_mainly_clear, R.drawable.night_mainly_clear,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    PARTLY_CLOUDY(
        "Partly cloudy", 2, R.drawable.day_partly_cloudy, R.drawable.night_partly_cloudy,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    OVERCAST(
        "Overcast", 3, R.drawable.day_overcast, R.drawable.night_overcast,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    FOG(
        "Fog", 45, R.drawable.day_fog, R.drawable.night_fog,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    DEPOSITING_RIME_FOG(
        "Depositing rime fog",
        48,
        R.drawable.day_depositing_rime_fog,
        R.drawable.night_depositing_rime_fog,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    LIGHT_DRIZZLE(
        "Light drizzle",
        51,
        R.drawable.day_drizzle_light,
        R.drawable.night_drizzle_light,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    MODERATE_DRIZZLE(
        "Moderate drizzle",
        53,
        R.drawable.day_drizzle_moderate,
        R.drawable.day_drizzle_moderate,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    DENSE_INTENSITY_DRIZZLE(
        "Dense intensity drizzle",
        55,
        R.drawable.day_drizzle_intensity,
        R.drawable.night_drizzle_intensity,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),

    LIGHT_FREEZING_DRIZZLE(
        "Light freezing drizzle",
        56,
        R.drawable.day_freezing_drizzle_light,
        R.drawable.night_freezing_drizzle_light,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    DENSE_INTENSITY_FREEZING_DRIZZLE(
        "Dense intensity freezing drizzle",
        57,
        R.drawable.day_freezing_drizzle_intensity,
        R.drawable.night_freezing_drizzle_intensity,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    SLIGHT_RAIN(
        "Slight rain",
        61,
        R.drawable.day_rain_slight,
        R.drawable.night_rain_slight,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),

    MODERATE_RAIN(
        "Moderate rain",
        63,
        R.drawable.day_rain_moderate,
        R.drawable.night_rain_moderate,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    HEAVY_INTENSITY_RAIN(
        "Heavy intensity rain",
        65,
        R.drawable.day_rain_intensity,
        R.drawable.night_rain_intensity,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    LIGHT_FREEZING_RAIN(
        "Light freezing rain",
        66,
        R.drawable.day_freezing_heavy,
        R.drawable.night_freezing_light,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    HEAVY_INTENSITY_FREEZING_RAIN(
        "Heavy intensity freezing rain",
        67,
        R.drawable.day_freezing_loght,
        R.drawable.night_freezing_heavy,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    SLIGHT_SNOW_FALL(
        "Slight snow fall",
        71,
        R.drawable.day_snow_fall_light,
        R.drawable.night_snow_fall_light,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),

    MODERATE_SNOW_FALL(
        "Moderate snow fall",
        73,
        R.drawable.day_snow_fall_moderate,
        R.drawable.night_snow_fall_moderate,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    HEAVY_INTENSITY_SNOW_FALL(
        "Heavy intensity snow fall",
        75,
        R.drawable.day_snow_fall_intensity,
        R.drawable.night_snow_fall_intensity,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    SNOW_GRAINS(
        "Snow grains",
        77,
        R.drawable.day_snow_grains,
        R.drawable.night_snow_grains,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    SLIGHT_RAIN_SHOWERS(
        "Slight rain showers",
        80,
        R.drawable.day_rain_shower_slight,
        R.drawable.night_rain_shower_slight,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),

    MODERATE_RAIN_SHOWERS(
        "Moderate rain showers",
        81,
        R.drawable.day_rain_shower_moderate,
        R.drawable.night_rain_shower_moderate,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    VIOLENT_RAIN_SHOWERS(
        "Violent rain showers",
        82,
        R.drawable.day_rain_shower_violent,
        R.drawable.night_rain_shower_violent,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    SLIGHT_SNOW_SHOWERS(
        "Slight snow showers",
        85,
        R.drawable.day_snow_shower_slight,
        R.drawable.night_snow_shower_slight,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    HEAVY_SNOW_SHOWERS(
        "Heavy snow showers",
        86,
        R.drawable.day_snow_shower_heavy,
        R.drawable.night_snow_shower_heavy,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    SLIGHT_OR_MODERATE_THUNDERSTORM(
        "Slight or moderate thunderstorm",
        95,
        R.drawable.day_thunderstrom_slight_or_moderate,
        R.drawable.night_thunderstrom_slight_or_moderate,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    SLIGHT_HAIL_THUNDERSTORM(
        "Slight hail thunderstorm",
        96,
        R.drawable.day_thunderstrom_with_slight_hail,
        R.drawable.night_thunderstrom_with_slight_hail,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    HEAVY_HAIL_THUNDERSTORM(
        "Heavy hail thunderstorm",
        99,
        R.drawable.day_thunderstrom_with_heavy_hail,
        R.drawable.night_thunderstrom_with_heavy_hail,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    ),
    UNKNOWN_STATE(
        "Clear sky", 0, R.drawable.day_clear_sky, R.drawable.night_clear_sky,
        Color(0xFFFFC701),
        Color(0xFF7E2FFF),
    )
    ;

    companion object {
        fun getWeatherState(code: Int): WeatherState {
            return entries.find { weatherState ->
                weatherState.code == code
            } ?: UNKNOWN_STATE
        }
    }
}


fun WeatherState.getImageResId(isModeNight: Boolean): Int {
    return if (isModeNight) this.nightImageResourceId else this.dayImageResourceId
}

fun WeatherState.getShadowColor(isModeNight: Boolean): Color {
    return if (isModeNight) this.dayShadowColor else this.nightShadowColor
}


