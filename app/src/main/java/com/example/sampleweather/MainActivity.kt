package com.example.sampleweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.sampleweather.ui.WeatherScreen
import com.example.sampleweather.ui.WeatherViewModel
import com.example.sampleweather.ui.theme.SampleWeatherTheme

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleWeatherTheme {
                WeatherScreen(viewModel = viewModel)
            }
        }
    }
}
