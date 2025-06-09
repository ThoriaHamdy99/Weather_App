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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.R
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun TodayWeather(
    modifier: Modifier,
    isNightMode: Boolean,
    numberOfDays: Int,
    temperatureList: List<String>,
    hours: List<String>,
    painters: List<Painter>
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
            for (i in 0..numberOfDays) {
                item {
                    TodayWeatherCard(
                        Modifier.width(88.dp),
                        isNightMode = isNightMode,
                        temperature = temperatureList[i],
                        hour = hours[i],
                        painter = painters[i]
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TodayWeatherPreview() {
    TodayWeather(
        modifier = Modifier,
        isNightMode = true,
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