package com.example.weather_app.ui.theme

import androidx.compose.ui.graphics.Color

fun primaryColor(
    isNightMode: Boolean
): Color {
    if (isNightMode) {
        return WhiteColor
    }
    return DarkPurpleColor
}

fun secondaryColor(
    isNightMode: Boolean
): Color {
    if (isNightMode) {
        return WhiteColor
    }
    return DarkGrayColor
}

fun primaryBackgroundColor(
    isNightMode: Boolean
): Color {
    if (isNightMode) {
        return DarkPurpleColor
    }
    return LightSkyBlueColor
}

fun secondaryBackgroundColor(
    isNightMode: Boolean
): Color {
    if (isNightMode) {
        return DarkBluishPurpleColor
    }
    return WhiteColor
}