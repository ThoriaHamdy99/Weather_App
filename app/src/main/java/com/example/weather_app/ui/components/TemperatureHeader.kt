package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.R
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.primaryColor

@Composable
fun TemperatureHeader(
    modifier: Modifier,
    isNightMode: Boolean,
    temperature: String,
    weatherStatus: String,
    highTemperature: String,
    lowTemperature: String
) {
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$temperature°C",
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 64.sp,
            lineHeight = 64.sp,
            letterSpacing = 0.25.sp,
            color = primaryColor(isNightMode = isNightMode)
        )

        Text(
            text = weatherStatus,
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.25.sp,
            color = primaryColor(isNightMode = isNightMode).copy(0.6f)
        )

        Row(
            modifier = Modifier
                .padding(
                    top = 12.dp
                )
                .background(
                    primaryColor(isNightMode).copy(0.08f),
                    RoundedCornerShape(100.dp),
                )
                .padding(
                    horizontal = 24.dp, vertical = 8.dp
                )
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.arrow_up_icon),
                contentDescription = "arrow_up_icon",
                modifier = Modifier.size(12.dp),
                colorFilter = ColorFilter.tint(primaryColor(isNightMode).copy(0.6f))
            )

            Text(
                text = "$highTemperature°C",
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.25.sp,
                color = primaryColor(isNightMode = isNightMode),
                modifier = Modifier.padding(start = 4.dp)
            )

            VerticalDivider(
                Modifier
                    .padding(vertical = 2.5.dp, horizontal = 8.dp),
                thickness = 1.dp,
                color = primaryColor(isNightMode = isNightMode).copy(0.24f)
            )

            Image(
                painter = painterResource(R.drawable.arrow_down_icon),
                contentDescription = "arrow_down_icon",
                modifier = Modifier.size(12.dp),
                colorFilter = ColorFilter.tint(primaryColor(isNightMode).copy(0.6f))
            )

            Text(
                text = "$lowTemperature°C",
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.25.sp,
                color = primaryColor(isNightMode = isNightMode),
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}