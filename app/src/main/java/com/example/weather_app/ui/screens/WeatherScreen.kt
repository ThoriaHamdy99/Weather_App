package com.example.weather_app.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.R
import com.example.weather_app.ui.components.LocationHeader
import com.example.weather_app.ui.components.TemperatureRanges
import com.example.weather_app.ui.components.TodayWeatherCard
import com.example.weather_app.ui.components.WeatherDetailsCard
import com.example.weather_app.ui.components.WeatherHeader
import com.example.weather_app.ui.model.WeatherDetails
import com.example.weather_app.ui.model.WeatherState
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.borderBackgroundColor
import com.example.weather_app.ui.theme.cardBackgroundColor
import com.example.weather_app.ui.theme.primaryBackgroundColor
import com.example.weather_app.ui.theme.primaryTextColor
import com.example.weather_app.ui.theme.secondaryBackgroundColor

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier
) {

    val isNightMode = true

    LazyColumn(
        modifier.then(
            Modifier
                .fillMaxSize()
                .background(
                    brush = getWeatherScreenBackground(isNightMode)
                )
        ),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        stickyHeader {
            LocationHeader(
                Modifier
                    .padding(
                        start = 24.dp, end = 24.dp, top = 64.dp
                    )
                    .fillMaxWidth(),
                isNightMode,
                painterResource(R.drawable.location_icon),
                "Baghdad"
            )
        }

        item {
            WeatherHeader(
                Modifier
                    .padding(horizontal = 12.dp),
                isNightMode,
                "24",
                WeatherState.CLEAR_SKY,
                "32", "20"
            )
        }
        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 24.dp),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                weatherDetailsList.forEach { weatherDetails ->
                    WeatherDetailsCard(
                        Modifier.weight(1f),
                        isNightMode,
                        weatherDetails
                    )
                }
            }
        }
        item {
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
        }

        item {
            LazyRow(
                modifier = Modifier.padding(top = 12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5) {
                    TodayWeatherCard(
                        Modifier.width(88.dp),
                        isNightMode = isNightMode,
                        "24",
                        "11:00",
                        painter = painterResource(R.drawable.day_clear_sky)
                    )
                }
            }
        }

        item {
            Text(
                "Next 7 days",
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                color = primaryTextColor(isNightMode = isNightMode),
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp, bottom = 12.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .background(
                        cardBackgroundColor(isNightMode).copy(0.7f),
                        RoundedCornerShape(24.dp)
                    )
                    .border(
                        1.dp,
                        borderBackgroundColor(isNightMode).copy(0.08f),
                        RoundedCornerShape(24.dp)
                    )
            ) {
                Column {
                    repeat(7) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Monday",
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
                                painter = painterResource(R.drawable.day_clear_sky),
                                contentDescription = "image",
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .height(height = 32.dp)
                                    .weight(1f),
                                contentScale = ContentScale.FillHeight
                            )

                            Box(
                                modifier = Modifier.weight(1.5f),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                TemperatureRanges(
                                    isNightMode = isNightMode,
                                    highTemperature = "32",
                                    lowTemperature = "20",
                                    fontSize = 14.sp,
                                    dividerPadding = 4.dp
                                )
                            }
                        }
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

val weatherDetailsList = listOf(
    WeatherDetails("wind", "13", " KM/h", R.drawable.fast_wind_icon),
    WeatherDetails("Humidity", "24", "%", R.drawable.humidity_icon),
    WeatherDetails("Rain", "2", "%", R.drawable.rain_icon),
    WeatherDetails("UV Index", "2", "", R.drawable.uv_icon),
    WeatherDetails("Pressure", "1012", " hPa", R.drawable.pressure_icon),
    WeatherDetails("Feels like", "22", "°C", R.drawable.temperature_icon)
)

fun getWeatherScreenBackground(
    isNightMode: Boolean = false
): Brush {
    return Brush.linearGradient(
        colors = listOf(
            primaryBackgroundColor(isNightMode),
            secondaryBackgroundColor(isNightMode)
        )
    )
}


@Preview(widthDp = 360, heightDp = 1222)
@Composable
fun WeatherScreenPreview() {
    WeatherScreen()
}