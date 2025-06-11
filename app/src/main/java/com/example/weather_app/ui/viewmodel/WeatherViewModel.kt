package com.example.weather_app.ui.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app.domain.model.LocationModel
import com.example.weather_app.domain.model.WeatherForecast
import com.example.weather_app.domain.repository.LocationRepository
import com.example.weather_app.domain.repository.WeatherRepository
import com.example.weather_app.ui.mapper.mapToUiModel
import com.example.weather_app.ui.model.CurrentTemperatureUIModel
import com.example.weather_app.ui.model.CurrentWeatherDetails
import com.example.weather_app.ui.model.CurrentWeatherStatus
import com.example.weather_app.ui.model.WeatherState
import com.example.weather_app.ui.model.WeatherUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow(initialWeatherUiModel)
    val uiState: StateFlow<WeatherUiModel> = _uiState

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch(
            Dispatchers.IO
        ) {
            try {
                val locationModel = locationRepository.getCurrentLocation()
                val weather = weatherRepository.getWeather(locationModel)
                onGetWeatherSuccess(locationModel, weather)
            } catch (throwable: Throwable) {
                onError(throwable)
            }
        }
    }

    private fun onError(throwable: Throwable) {
        Log.d(WeatherViewModel::class.java.name, "No Data: ${throwable.message}")
    }

    private fun onGetWeatherSuccess(
        locationModel: LocationModel,
        weather: WeatherForecast
    ) {
        val updatedWeather = if (locationModel.city != null) {
            weather.copy(cityName = locationModel.city)
        } else if (locationModel.country != null) {
            weather.copy(cityName = locationModel.country)
        } else {
            weather
        }
        _uiState.update { updatedWeather.mapToUiModel() }
    }
}


val initialWeatherUiModel = WeatherUiModel(
    isNightMode = true,
    countryName = "",
    currentTemperatureUiModel = CurrentTemperatureUIModel(
        temperature = "",
        weatherState = WeatherState.CLEAR_SKY,
        minTemp = "",
        maxTemp = ""
    ),
    currentWeatherDetails = listOf(
        CurrentWeatherDetails(CurrentWeatherStatus.WIND, value = "0"),
        CurrentWeatherDetails(CurrentWeatherStatus.HUMIDITY, value = "0"),
        CurrentWeatherDetails(CurrentWeatherStatus.RAIN, value = "0"),
        CurrentWeatherDetails(CurrentWeatherStatus.UV_INDEX, value = "0"),
        CurrentWeatherDetails(CurrentWeatherStatus.PRESSURE, value = "0"),
        CurrentWeatherDetails(CurrentWeatherStatus.FEELS_LIKE, value = "0")
    ),
    hourlyWeather = emptyList(),
    dailyWeather = emptyList()
)