package com.example.sampleweather.model

import com.example.sampleweather.R

data class WeeklyForecast(
    val date: String,
    val weather: WeatherItem,
    val minimumTemperature: Int,
    val maximumTemperature: Int,
    val chanceOfRain: Int
)

enum class WeatherItem(val weather: Int, val icon: Int) {
    SUNNY(R.string.sunny, R.drawable.sunny),
    RAINY(R.string.rainy, R.drawable.rain),
    SNOW(R.string.snow, R.drawable.snow),
    THUNDER(R.string.thunder, R.drawable.thunder)
}
