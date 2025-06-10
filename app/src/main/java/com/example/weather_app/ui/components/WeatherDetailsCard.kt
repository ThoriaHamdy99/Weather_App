package com.example.weather_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.presentation.model.WeatherDetails
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.borderBackgroundColor
import com.example.weather_app.ui.theme.cardBackgroundColor
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun WeatherDetailsCard(
    modifier: Modifier,
    isNightMode: Boolean,
    weatherDetails: WeatherDetails
) {
    Column(
        modifier = modifier
            .height(115.dp)
            .background(
                cardBackgroundColor(isNightMode).copy(0.7f),
                RoundedCornerShape(24.dp)
            )
            .border(
                1.dp,
                borderBackgroundColor(isNightMode).copy(0.08f),
                RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(weatherDetails.iconResourceId),
            contentDescription = "details icon",
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        Row {
            Text(
                weatherDetails.value,
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                color = primaryTextColor(isNightMode).copy(0.87f)
            )
            Text(
                weatherDetails.measurement,
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                color = primaryTextColor(isNightMode).copy(0.87f)
            )
        }

        Text(
            weatherDetails.title,
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.25.sp,
            color = primaryTextColor(isNightMode).copy(0.6f),
            modifier = Modifier.padding(bottom = 16.dp)
        )

    }
}