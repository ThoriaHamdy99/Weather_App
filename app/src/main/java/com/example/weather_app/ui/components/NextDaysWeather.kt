package com.example.weather_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.domain.model.DailyWeather
import com.example.weather_app.presentation.model.WeatherState
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.borderBackgroundColor
import com.example.weather_app.ui.theme.cardBackgroundColor
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun NextDaysWeather(
    modifier: Modifier = Modifier,
    isNightMode: Boolean,
    numberOfNextDays: Int,
    dailyWeather: List<DailyWeather>

) {
    Column(
        modifier = modifier
    ) {
        Text(
            "Next $numberOfNextDays days",
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode = isNightMode),
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 12.dp
            )
        )

        Box(
            modifier = Modifier
                .background(
                    cardBackgroundColor(isNightMode).copy(0.7f),
                    RoundedCornerShape(24.dp)
                )
                .border(
                    1.dp,
                    borderBackgroundColor(isNightMode).copy(0.08f),
                    RoundedCornerShape(24.dp)
                )
                .padding(top = 4.dp)
        ) {
            Column {
                dailyWeather.forEach { dailyWeather ->
                    val weatherState = WeatherState.getWeatherState(dailyWeather.weatherCode)
                    NextDayCard(
                        isNightMode = isNightMode,
                        day = dailyWeather.date,
                        painter = painterResource(
                            if (isNightMode) {
                                weatherState.nightImageResourceId
                            } else weatherState.dayImageResourceId
                        ),
                        highTemperature = dailyWeather.maxTemp.toInt().toString(),
                        lowTemperature = dailyWeather.minTemp.toInt().toString()
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = borderBackgroundColor(isNightMode).copy(0.08f),
                    )
                }
            }
        }
    }
}