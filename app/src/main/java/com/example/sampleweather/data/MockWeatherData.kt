package com.example.sampleweather.data

import com.example.sampleweather.model.DailyForecast
import com.example.sampleweather.model.WeeklyForecast
import com.example.sampleweather.model.HourlyForecast
import com.example.sampleweather.model.WeatherItem

val WEEKLY_FORECAST = listOf(
    WeeklyForecast("1日(月)", WeatherItem.SUNNY, 12, 18, 40),
    WeeklyForecast("2日(火)", WeatherItem.RAINY, 5, 10, 85),
    WeeklyForecast("3日(水)", WeatherItem.SNOW, 0, 5, 70),
    WeeklyForecast("4日(木)", WeatherItem.THUNDER, 8, 13, 100),
    WeeklyForecast("5日(金)", WeatherItem.RAINY, 5, 10, 90),
    WeeklyForecast("6日(土)", WeatherItem.SUNNY, 12, 18, 10),
    WeeklyForecast("7日(日)", WeatherItem.SNOW, 0, 5, 80)
)

val DAILY_FORECASTS: List<DailyForecast> =
    WEEKLY_FORECAST.map { DailyForecast(it.date, it.weather.createHourlyWeather()) }

private fun WeatherItem.createHourlyWeather(): List<HourlyForecast> {
    return (0..23).map { hour -> HourlyForecast(hour, weather, icon, getTemperature(), getChanceOfRain()) }
}

private fun WeatherItem.getTemperature(): Int {
    return when (this) {
        WeatherItem.SUNNY -> (12..18).random()
        WeatherItem.RAINY -> (5..10).random()
        WeatherItem.SNOW -> (0..5).random()
        WeatherItem.THUNDER -> (8..13).random()
    }
}

private fun WeatherItem.getChanceOfRain(): Int {
    return when (this) {
        WeatherItem.SUNNY -> (0..40).random()
        WeatherItem.RAINY -> (50..100).random()
        WeatherItem.SNOW -> (60..100).random()
        WeatherItem.THUNDER -> (70..100).random()
    }
}
