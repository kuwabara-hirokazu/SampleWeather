package com.example.sampleweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleweather.data.MockPokemonData
import com.example.sampleweather.data.MockWeatherData
import com.example.sampleweather.model.DailyForecast
import com.example.sampleweather.model.PokemonArea
import com.example.sampleweather.model.WeeklyForecast

class WeatherViewModel : ViewModel() {

    private val _isWeeklyState = MutableLiveData(false)
    val isWeeklyState: LiveData<Boolean> = _isWeeklyState

    private val _pokemonArea = MutableLiveData<PokemonArea>()
    val pokemonArea: LiveData<PokemonArea> = _pokemonArea

    private val _dailyForecasts = MutableLiveData<List<DailyForecast>>()
    val dailyForecasts: LiveData<List<DailyForecast>> = _dailyForecasts

    private val _weeklyForecasts = MutableLiveData<List<WeeklyForecast>>()
    val weeklyForecasts: LiveData<List<WeeklyForecast>> = _weeklyForecasts

    private val _pokemonData = MutableLiveData<List<String>>()
    val pokemonData: LiveData<List<String>> = _pokemonData

    fun onStateChange(checkedWeeklyState: Boolean) {
        _isWeeklyState.value = checkedWeeklyState
    }

    fun onAreaChange(pokemonArea: PokemonArea) {
        _pokemonArea.value = pokemonArea
    }

    fun getWeatherData(area: PokemonArea) {
        when (isWeeklyState.value) {
            true -> {
                getWeeklyForecastData(area)
                getWeeklyPokemonData(area)
            }
            false -> {
                getDailyForecastData(area)
                getDailyPokemonData(area)
            }
        }
    }

    private fun getDailyForecastData(area: PokemonArea) {
        _dailyForecasts.value = MockWeatherData().createDailyForecasts(area)
    }

    private fun getWeeklyForecastData(area: PokemonArea) {
        _weeklyForecasts.value = MockWeatherData().createForecast(area)
    }

    private fun getWeeklyPokemonData(area: PokemonArea) {
        _pokemonData.value = MockPokemonData().getWeeklyPokemonData(area)
    }

    private fun getDailyPokemonData(area: PokemonArea) {
        _pokemonData.value = MockPokemonData().getDailyPokemonData(area)
    }
}
