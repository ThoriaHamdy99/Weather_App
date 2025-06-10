package com.example.weather_app.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weather_app.R
import com.example.weather_app.presentation.viewmodel.WeatherViewModel
import com.example.weather_app.ui.components.LocationHeader
import com.example.weather_app.ui.components.NextDaysWeather
import com.example.weather_app.ui.components.TodayWeather
import com.example.weather_app.ui.components.WeatherDetails
import com.example.weather_app.ui.components.WeatherHeader
import com.example.weather_app.ui.theme.primaryBackgroundColor
import com.example.weather_app.ui.theme.secondaryBackgroundColor

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel
) {

    val weatherUiModel = viewModel.uiState.collectAsState().value
    val isNightMode = weatherUiModel.isNightMode

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
                weatherUiModel.countryName
            )
        }

        item {
            WeatherHeader(
                Modifier
                    .padding(horizontal = 12.dp),
                isNightMode,
                weatherUiModel.currentTemperatureUiModel
            )
        }
        item {
            WeatherDetails(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 24.dp),
                isNightMode,
                weatherUiModel.currentWeatherDetails
            )
        }

        item {
            TodayWeather(
                modifier = Modifier,
                isNightMode = isNightMode,
                weatherUiModel.hourlyWeather
            )
        }

        item {
            NextDaysWeather(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                isNightMode = isNightMode,
                numberOfNextDays = 7,
                dailyWeather = weatherUiModel.dailyWeather
            )
        }
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
