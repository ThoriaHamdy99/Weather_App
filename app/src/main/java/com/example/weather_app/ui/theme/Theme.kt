package com.example.weather_app.ui.theme

import androidx.compose.ui.graphics.Color

fun cardBackgroundColor(
    isNightMode: Boolean
): Color {
    if (isNightMode) {
        return DarkPurpleColor
    }
    return WhiteColor
}

fun borderBackgroundColor(
    isNightMode: Boolean
): Color {
    if (isNightMode) {
        return WhiteColor
    }
    return DarkPurpleColor
}

fun primaryTextColor(
    isNightMode: Boolean
): Color {
    if (isNightMode) {
        return WhiteColor
    }
    return DarkPurpleColor
}

fun secondaryTextColor(
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