package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.secondaryColor

@Composable
fun LocationHeader(
    modifier: Modifier = Modifier,
    isNightMode: Boolean,
    icon: Painter,
    address: String
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = "location icon",
            colorFilter = ColorFilter.tint(
                secondaryColor(isNightMode)
            )
        )
        Text(
            text = address,
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            color = secondaryColor(isNightMode),
            modifier = Modifier
                .padding(start = 4.dp)
                .align(Alignment.CenterVertically)
        )
    }
}