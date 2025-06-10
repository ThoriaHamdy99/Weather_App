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
import com.example.weather_app.presentation.model.DailyWeatherUiModel
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.borderBackgroundColor
import com.example.weather_app.ui.theme.cardBackgroundColor
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun NextDaysWeather(
    modifier: Modifier = Modifier,
    isNightMode: Boolean,
    numberOfNextDays: Int,
    dailyWeather: List<DailyWeatherUiModel>
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
                dailyWeather.forEachIndexed { index, weather ->
                    NextDayCard(
                        isNightMode = isNightMode,
                        day = weather.dayOfWeek,
                        painter = painterResource(weather.weatherIcon),
                        highTemperature = weather.maxTemp,
                        lowTemperature = weather.minTemp
                    )
                    if ((index + 1) != 7) {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = borderBackgroundColor(isNightMode).copy(0.08f),
                        )
                    }
                }
            }
        }
    }
}