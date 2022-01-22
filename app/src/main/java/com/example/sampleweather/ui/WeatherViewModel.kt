package com.example.sampleweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleweather.data.MockPokemonData
import com.example.sampleweather.model.PokemonArea

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

    fun getDailyPokemonData(area: PokemonArea): List<String> {
        return MockPokemonData().getDailyPokemonData(area)
    }

    fun getWeeklyPokemonData(area: PokemonArea): List<String> {
        return MockPokemonData().getWeeklyPokemonData(area)
    }
}
