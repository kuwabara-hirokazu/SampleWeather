package com.example.sampleweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sampleweather.ui.WeeklyWeather
import com.example.sampleweather.ui.theme.SampleWeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleWeatherTheme {
                WeeklyWeather()
            }
        }
    }
}
