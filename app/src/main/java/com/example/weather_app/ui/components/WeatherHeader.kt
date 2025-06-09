package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.model.WeatherState
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun WeatherHeader(
    modifier: Modifier,
    isNightMode: Boolean,
    temperature: String,
    weatherState: WeatherState,
    highTemperature: String,
    lowTemperature: String
) {
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = if (isNightMode) painterResource(weatherState.nightImageResourceId) else painterResource(
                weatherState.dayImageResourceId
            ),
            contentDescription = "image",
            modifier = Modifier
                .padding(12.dp)
                .size(width = 220.dp, height = 200.dp)
        )

        Text(
            text = "$temperature°C",
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 64.sp,
            lineHeight = 64.sp,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode = isNightMode)
        )

        Text(
            text = weatherState.state,
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode = isNightMode).copy(0.6f)
        )

        TemperatureRanges(
            Modifier
                .padding(
                    top = 12.dp
                )
                .background(
                    primaryTextColor(isNightMode).copy(0.08f),
                    RoundedCornerShape(100.dp),
                )
                .padding(
                    horizontal = 24.dp, vertical = 8.dp
                ),
            isNightMode,
            highTemperature,
            lowTemperature,
            16.sp,
            8.dp
        )
    }
}