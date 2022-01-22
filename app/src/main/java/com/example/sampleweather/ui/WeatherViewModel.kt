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

    private val _isWeeklyState = MutableLiveData<Boolean>()
    val isWeeklyState: LiveData<Boolean> = _isWeeklyState

    private val _pokemonArea = MutableLiveData<PokemonArea>()
    val pokemonArea: LiveData<PokemonArea> = _pokemonArea

    fun onStateChange(checkedWeeklyState: Boolean) {
        _isWeeklyState.value = checkedWeeklyState
    }

    fun onAreaChange(pokemonArea: PokemonArea) {
        _pokemonArea.value = pokemonArea
    }

    fun getDailyForecastData(area: PokemonArea): List<DailyForecast> {
        return MockWeatherData().createDailyForecasts(area)
    }

    fun getWeeklyForecastData(area: PokemonArea): List<WeeklyForecast> {
        return MockWeatherData().createForecast(area)
    }

    fun getDailyPokemonData(area: PokemonArea): List<String> {
        return MockPokemonData().getDailyPokemonData(area)
    }

    fun getWeeklyPokemonData(area: PokemonArea): List<String> {
        return MockPokemonData().getWeeklyPokemonData(area)
    }
}
