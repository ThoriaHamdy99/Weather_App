package com.example.weather_app.ui.utils

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.toLocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun String.getWeekday(): String {
    val date = this.toLocalDate()
    return when (date.dayOfWeek) {
        DayOfWeek.MONDAY -> "Monday"
        DayOfWeek.TUESDAY -> "Tuesday"
        DayOfWeek.WEDNESDAY -> "Wednesday"
        DayOfWeek.THURSDAY -> "Thursday"
        DayOfWeek.FRIDAY -> "Friday"
        DayOfWeek.SATURDAY -> "Saturday"
        DayOfWeek.SUNDAY -> "Sunday"
    }
}