package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun NextDayCard(
    isNightMode: Boolean,
    day: String,
    painter: Painter,
    highTemperature: String,
    lowTemperature: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = day,
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode = isNightMode).copy(0.6f),
            modifier = Modifier.weight(1.5f),
            textAlign = TextAlign.Start
        )
        Image(
            painter = painter,
            contentDescription = "image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 7.dp)
                .height(height = 40.dp)
                .weight(1f),
            contentScale = ContentScale.FillHeight
        )

        Box(
            modifier = Modifier.weight(1.5f),
            contentAlignment = Alignment.CenterEnd
        ) {
            TemperatureRanges(
                isNightMode = isNightMode,
                highTemperature = highTemperature,
                lowTemperature = lowTemperature,
                fontSize = 14.sp,
                dividerPadding = 4.dp
            )
        }
    }
}