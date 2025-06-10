package com.example.weather_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.presentation.model.HourlyWeatherUiModel
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun TodayWeather(
    modifier: Modifier,
    isNightMode: Boolean,
    hourlyWeatherList: List<HourlyWeatherUiModel>
) {
    Column(
        modifier = modifier
    ) {
        Text(
            "Today",
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode = isNightMode),
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        LazyRow(
            modifier = Modifier.padding(top = 12.dp),
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (i in 0..23) {
                if (hourlyWeatherList.isEmpty()) return@LazyRow
                item {
                    TodayWeatherCard(
                        Modifier.width(88.dp),
                        isNightMode = isNightMode,
                        temperature = hourlyWeatherList[i].temperature,
                        hour = hourlyWeatherList[i].time,
                        painter = painterResource(hourlyWeatherList[i].weatherIcon)
                    )
                }
            }
        }
    }
}
