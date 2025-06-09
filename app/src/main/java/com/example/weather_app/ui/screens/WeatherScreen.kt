package com.example.weather_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather_app.R
import com.example.weather_app.ui.components.LocationHeader
import com.example.weather_app.ui.components.TemperatureHeader
import com.example.weather_app.ui.theme.primaryBackgroundColor
import com.example.weather_app.ui.theme.secondaryBackgroundColor

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier
) {

    val isNightMode = false

    Column(
        modifier.then(
            Modifier
                .fillMaxSize()
                .background(
                    brush = getWeatherScreenBackground(isNightMode)
                )
        )
    ) {
        LocationHeader(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    start = 24.dp, end = 24.dp, top = 64.dp
                ),
            isNightMode,
            painterResource(R.drawable.location_icon),
            "Baghdad"
        )
        Image(
            painter = painterResource(R.drawable.mainly_clear_day),
            contentDescription = "image",
            modifier = Modifier
                .padding(12.dp)
                .size(width = 220.dp, height = 200.dp)
                .align(Alignment.CenterHorizontally)
        )
        TemperatureHeader(
            Modifier
                .padding(horizontal = 12.dp)
                .align(Alignment.CenterHorizontally),
            false,
            "24",
            "Partly cloudy",
            "32", "20"
        )
    }
}

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