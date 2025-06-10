package com.example.weather_app.di

import com.example.weather_app.data.datasource.remote.apiservice.HttpClientProvider
import com.example.weather_app.data.datasource.remote.apiservice.HttpClientProviderImp
import com.example.weather_app.data.datasource.remote.apiservice.locationLink
import com.example.weather_app.data.datasource.remote.apiservice.weatherLink
import com.example.weather_app.data.datasource.remote.location.LocationDataSource
import com.example.weather_app.data.datasource.remote.location.LocationDataSourceImpl
import com.example.weather_app.data.datasource.remote.weather.WeatherDataSource
import com.example.weather_app.data.datasource.remote.weather.WeatherDataSourceImpl
import com.example.weather_app.data.repository.LocationRepositoryImpl
import com.example.weather_app.data.repository.WeatherRepositoryImpl
import com.example.weather_app.domain.repository.LocationRepository
import com.example.weather_app.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {
    single<HttpClientProvider> { HttpClientProviderImp() }

    factory<LocationDataSource> {
        LocationDataSourceImpl(
            httpClientProvider = get(),
            ipLocationLink = locationLink
        )
    }
    factory<WeatherDataSource> {
        WeatherDataSourceImpl(
            httpClientProvider = get(),
            weatherLink = weatherLink
        )
    }

    factory<LocationRepository> { LocationRepositoryImpl(get()) }
    factory<WeatherRepository> { WeatherRepositoryImpl(get()) }

}