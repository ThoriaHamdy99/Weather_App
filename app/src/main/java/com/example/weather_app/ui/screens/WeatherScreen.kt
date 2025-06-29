package com.example.weather_app.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.weather_app.R
import com.example.weather_app.ui.components.LocationHeader
import com.example.weather_app.ui.components.NextDaysWeather
import com.example.weather_app.ui.components.TodayWeather
import com.example.weather_app.ui.components.WeatherDetails
import com.example.weather_app.ui.components.WeatherHeader
import com.example.weather_app.ui.model.WeatherUiModel
import com.example.weather_app.ui.theme.primaryBackgroundColor
import com.example.weather_app.ui.theme.secondaryBackgroundColor
import com.example.weather_app.ui.viewmodel.WeatherViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    window: Window,
    viewModel: WeatherViewModel
) {

    val weatherUiModel = viewModel.uiState.collectAsState().value
    val isNightMode = weatherUiModel.isNightMode
    WindowCompat.getInsetsController(window, LocalView.current).isAppearanceLightStatusBars = false
    WeatherScreenContent(modifier, window, weatherUiModel, isNightMode)
}

@Composable
fun WeatherScreenContent(
    modifier: Modifier,
    window: Window,
    weatherUiModel: WeatherUiModel,
    isNightMode: Boolean
) {
    updateStatusBarTextColor(weatherUiModel, window)

    val lazyListState = rememberLazyListState()
    val animationTriggerHeight = 250f

    LazyColumn(
        state = lazyListState,
        modifier = modifier.then(
            Modifier
                .fillMaxSize()
                .background(
                    brush = getWeatherScreenBackground(isNightMode)
                )
        ),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        item {
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
            val scrollProgress = calculateScrollProgress(lazyListState, animationTriggerHeight)
            WeatherHeader(
                scrollProgress,
                Modifier,
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

@Composable
private fun updateStatusBarTextColor(
    weatherUiModel: WeatherUiModel,
    window: Window
) {
    if (weatherUiModel.isNightMode) {
        window.statusBarColor = Color.White.toArgb()
    } else {
        window.statusBarColor = Color.Black.toArgb()
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


fun calculateScrollProgress(
    lazyListState: LazyListState,
    animationTriggerHeight: Float
): Float {
    val progress = if (lazyListState.firstVisibleItemIndex == 0) {
        (lazyListState.firstVisibleItemScrollOffset / animationTriggerHeight).coerceIn(
            0.0f,
            1f,
        )
    } else {
        1f
    }
    return progress
}