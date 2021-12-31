package com.example.sampleweather.model

data class DailyForecast(
    val date: String,
    val forecasts: List<HourlyForecast>
)

data class HourlyForecast(
    val hour: Int,
    val weather: String,
    val weatherIcon: Int,
    val temperature: Int,
    val chanceOfRain: Int
)
