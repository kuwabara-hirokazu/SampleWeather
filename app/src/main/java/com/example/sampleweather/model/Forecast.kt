package com.example.sampleweather.model

data class Forecast(
    val date: String,
    val weather: String,
    val weatherIcon: Int,
    val minimumTemperature: Int,
    val maximumTemperature: Int,
    val chanceOfRain: Int
)
