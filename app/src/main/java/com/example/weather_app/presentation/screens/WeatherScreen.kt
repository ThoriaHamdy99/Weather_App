package com.example.weather_app.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather_app.R
import com.example.weather_app.ui.components.LocationHeader
import com.example.weather_app.ui.components.NextDaysWeather
import com.example.weather_app.ui.components.TodayWeather
import com.example.weather_app.ui.components.WeatherDetails
import com.example.weather_app.ui.components.WeatherHeader
import com.example.weather_app.presentation.model.WeatherDetails
import com.example.weather_app.presentation.model.WeatherState
import com.example.weather_app.ui.theme.primaryBackgroundColor
import com.example.weather_app.ui.theme.secondaryBackgroundColor

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier
) {

    val isNightMode = false

    LazyColumn(
        modifier.then(
            Modifier
                .fillMaxSize()
                .background(
                    brush = getWeatherScreenBackground(isNightMode)
                )
        ),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        stickyHeader {
            LocationHeader(
                Modifier
                    .padding(
                        start = 24.dp, end = 24.dp, top = 64.dp
                    )
                    .fillMaxWidth(),
                isNightMode,
                painterResource(R.drawable.location_icon),
                "Baghdad"
            )
        }

        item {
            WeatherHeader(
                Modifier
                    .padding(horizontal = 12.dp),
                isNightMode,
                "24",
                WeatherState.CLEAR_SKY,
                "32", "20"
            )
        }
        item {
            WeatherDetails(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 24.dp),
                isNightMode,
                weatherDetailsList
            )
        }

        item {
            TodayWeather(
                modifier = Modifier,
                isNightMode = isNightMode,
                numberOfDays = 7,
                temperatureList = listOf("20", "30", "40", "50", "60", "70", "80"),
                hours = listOf("11:00", "12:00", "01:00", "02:00", "03:00", "04:00", "05:00"),
                painters = listOf(
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                )
            )
        }

        item {
            NextDaysWeather(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                isNightMode = isNightMode,
                numberOfNextDays = 7,
                days = listOf(
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    "Saturday",
                    "Sunday"
                ),
                painters = listOf(
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky),
                    painterResource(R.drawable.day_clear_sky)
                ),
                highTemperatureList = listOf("20", "30", "40", "50", "60", "70", "80"),
                lowTemperatureList = listOf("20", "30", "40", "50", "60", "70", "80")
            )
        }
    }
}

val weatherDetailsList = listOf(
    WeatherDetails("wind", "13", " KM/h", R.drawable.fast_wind_icon),
    WeatherDetails("Humidity", "24", "%", R.drawable.humidity_icon),
    WeatherDetails("Rain", "2", "%", R.drawable.rain_icon),
    WeatherDetails("UV Index", "2", "", R.drawable.uv_icon),
    WeatherDetails("Pressure", "1012", " hPa", R.drawable.pressure_icon),
    WeatherDetails("Feels like", "22", "°C", R.drawable.temperature_icon)
)

fun getWeatherScreenBackground(
    isNightMode: Boolean = false
): Brush {
    return Brush.linearGradient(
        colors = listOf(
            primaryBackgroundColor(isNightMode),
            secondaryBackgroundColor(isNightMode)
        )
    )
}


@Preview(widthDp = 360, heightDp = 1222)
@Composable
fun WeatherScreenPreview() {
    WeatherScreen()
}