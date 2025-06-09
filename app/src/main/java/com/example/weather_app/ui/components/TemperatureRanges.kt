package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.R
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun TemperatureRanges(
    modifier: Modifier = Modifier,
    isNightMode: Boolean,
    highTemperature: String,
    lowTemperature: String,
    fontSize: TextUnit,
    dividerPadding: Dp
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.arrow_up_icon),
            contentDescription = "arrow_up_icon",
            modifier = Modifier.size(12.dp),
            colorFilter = ColorFilter.tint(primaryTextColor(isNightMode).copy(0.6f))
        )

        Text(
            text = "$highTemperature°C",
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.Medium,
            fontSize = fontSize,
            lineHeight = fontSize,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode = isNightMode),
            modifier = Modifier.padding(start = 4.dp)
        )

        VerticalDivider(
            Modifier
                .padding(vertical = 2.5.dp, horizontal = dividerPadding),
            thickness = 1.dp,
            color = primaryTextColor(isNightMode = isNightMode).copy(0.24f)
        )

        Image(
            painter = painterResource(R.drawable.arrow_down_icon),
            contentDescription = "arrow_down_icon",
            modifier = Modifier.size(12.dp),
            colorFilter = ColorFilter.tint(primaryTextColor(isNightMode).copy(0.6f))
        )

        Text(
            text = "$lowTemperature°C",
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.Medium,
            fontSize = fontSize,
            lineHeight = fontSize,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode = isNightMode),
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}