package com.example.weather_app.di

import com.example.weather_app.ui.viewmodel.WeatherViewModel
import org.koin.dsl.module

val uiModule = module {
    factory<WeatherViewModel> {
        WeatherViewModel(
            get(), get()
        )
    }
}
