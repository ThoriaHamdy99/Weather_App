package com.example.weather_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather_app.ui.model.CurrentWeatherDetails

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WeatherDetails(
    modifier: Modifier = Modifier,
    isNightMode: Boolean,
    currentWeatherDetailsList: List<CurrentWeatherDetails>
) {
    FlowRow(
        modifier = modifier,
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        currentWeatherDetailsList.forEach { weatherDetails ->
            WeatherDetailsCard(
                Modifier.weight(1f),
                isNightMode,
                weatherDetails
            )
        }
    }
}