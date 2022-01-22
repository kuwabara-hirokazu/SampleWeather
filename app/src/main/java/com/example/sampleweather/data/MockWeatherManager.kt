package com.example.sampleweather.data

import com.example.sampleweather.model.DailyForecast
import com.example.sampleweather.model.HourlyForecast
import com.example.sampleweather.model.PokemonArea
import com.example.sampleweather.model.WeatherItem
import com.example.sampleweather.model.WeeklyForecast

class MockWeatherManager {

    fun createForecast(area: PokemonArea): List<WeeklyForecast> {
        val forecasts = when (area) {
            PokemonArea.KANTO -> listOf(
                WeatherItem.SUNNY,
                WeatherItem.RAINY,
                WeatherItem.SNOW,
                WeatherItem.THUNDER,
                WeatherItem.FOG,
                WeatherItem.SUNNY,
                WeatherItem.SNOW
            )
            PokemonArea.JOHTO -> listOf(
                WeatherItem.RAINY,
                WeatherItem.SUNNY,
                WeatherItem.SNOW,
                WeatherItem.THUNDER,
                WeatherItem.SNOW,
                WeatherItem.SUNNY,
                WeatherItem.FOG
            )
            PokemonArea.HOEEN -> listOf(
                WeatherItem.SNOW,
                WeatherItem.THUNDER,
                WeatherItem.SUNNY,
                WeatherItem.RAINY,
                WeatherItem.SUNNY,
                WeatherItem.SNOW,
                WeatherItem.FOG
            )
            PokemonArea.SINNOH -> listOf(
                WeatherItem.THUNDER,
                WeatherItem.FOG,
                WeatherItem.SUNNY,
                WeatherItem.RAINY,
                WeatherItem.SUNNY,
                WeatherItem.SNOW,
                WeatherItem.SNOW
            )
        }

        return (0..6).map {
            WeeklyForecast("11/${it + 1}", forecasts[it])
        }
    }

    fun createDailyForecasts(area: PokemonArea): List<DailyForecast> {
        return createForecast(area).map { DailyForecast(it.date, it.weather.createHourlyWeather()) }
    }

    private fun WeatherItem.createHourlyWeather(): List<HourlyForecast> {
        return (0..23).map { hour ->
            HourlyForecast(
                hour,
                weather,
                icon,
                getTemperature(),
                getChanceOfRain()
            )
        }
    }

    private fun WeatherItem.getTemperature(): Int {
        return when (this) {
            WeatherItem.SUNNY -> (12..18).random()
            WeatherItem.RAINY -> (5..10).random()
            WeatherItem.SNOW -> (0..5).random()
            WeatherItem.THUNDER -> (8..13).random()
            WeatherItem.FOG -> (10..15).random()
        }
    }

    private fun WeatherItem.getChanceOfRain(): Int {
        return when (this) {
            WeatherItem.SUNNY -> (0..40).random()
            WeatherItem.RAINY -> (50..100).random()
            WeatherItem.SNOW -> (60..100).random()
            WeatherItem.THUNDER -> (70..100).random()
            WeatherItem.FOG -> (40..80).random()
        }
    }
}
