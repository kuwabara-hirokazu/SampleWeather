package com.example.sampleweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleweather.data.MockPokemonManager
import com.example.sampleweather.data.MockWeatherManager
import com.example.sampleweather.model.DailyForecast
import com.example.sampleweather.model.PokemonArea
import com.example.sampleweather.model.WeeklyForecast

class WeatherViewModel : ViewModel() {

    private val weatherManager = MockWeatherManager()
    private val pokemonManager = MockPokemonManager()

    private val _isWeeklyState = MutableLiveData(false)
    val isWeeklyState: LiveData<Boolean> = _isWeeklyState

    private val _pokemonArea = MutableLiveData<PokemonArea>()
    val pokemonArea: LiveData<PokemonArea> = _pokemonArea

    private val _dayCount = MutableLiveData<Int>()
    val dayCount: LiveData<Int> = _dayCount

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

    fun onDayChange(forecasts: List<DailyForecast>, isPressedNextDay: Boolean) {
        val dayCount = dayCount.value ?: 0
        when (isPressedNextDay) {
            true -> {
                if (dayCount < forecasts.size - 1) {
                    _dayCount.value = dayCount + 1
                }
            }
            false -> {
                if (0 < dayCount) {
                    _dayCount.value = dayCount - 1
                }
            }
        }
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
        _dailyForecasts.value = weatherManager.createDailyForecasts(area)
    }

    private fun getWeeklyForecastData(area: PokemonArea) {
        _weeklyForecasts.value = weatherManager.createForecast(area)
    }

    private fun getWeeklyPokemonData(area: PokemonArea) {
        _pokemonData.value = pokemonManager.getWeeklyPokemonData(area)
    }

    private fun getDailyPokemonData(area: PokemonArea) {
        _pokemonData.value = pokemonManager.getDailyPokemonData(area)
    }
}
