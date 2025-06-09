package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.borderBackgroundColor
import com.example.weather_app.ui.theme.cardBackgroundColor
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun TodayWeatherCard(
    modifier: Modifier = Modifier,
    isNightMode: Boolean,
    temperature: String,
    hour: String,
    painter: Painter
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
                .background(
                    cardBackgroundColor(isNightMode).copy(0.7f),
                    RoundedCornerShape(24.dp)
                )
                .border(
                    1.dp,
                    borderBackgroundColor(isNightMode).copy(0.08f),
                    RoundedCornerShape(24.dp)
                )
                .padding(top = 62.dp, start = 12.dp, end = 12.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "$temperature°C",
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.25.sp,
                color = primaryTextColor(isNightMode = isNightMode).copy(0.87f),
            )
            Text(
                hour,
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.25.sp,
                color = primaryTextColor(isNightMode = isNightMode).copy(0.87f),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Image(
            painter = painter,
            contentDescription = "image",
            modifier = Modifier.height(height = 58.dp),
            contentScale = ContentScale.FillHeight
        )
    }
}