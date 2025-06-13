package com.example.weather_app.di

import org.koin.dsl.module

val appModule = module {
    includes(dataModule, uiModule)
}
