package com.example.weather_app

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.weather_app.di.appModule
import com.example.weather_app.ui.screens.WeatherScreen
import com.example.weather_app.ui.viewmodel.WeatherViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            logger(PrintLogger())
            androidContext(this@MainActivity)
            modules(appModule)
        }
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                WeatherScreen(
                    window = this@MainActivity.window,
                    viewModel = get<WeatherViewModel>()
                )
            }
        }
    }
}