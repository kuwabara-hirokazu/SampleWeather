package com.example.sampleweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.sampleweather.model.PokemonArea
import com.example.sampleweather.ui.WeatherScreen
import com.example.sampleweather.ui.WeatherViewModel
import com.example.sampleweather.ui.theme.SampleWeatherTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWeatherData(PokemonArea.KANTO)
        setContent {
            SampleWeatherTheme {
                WeatherScreen(viewModel = viewModel)
            }
        }
    }
}
