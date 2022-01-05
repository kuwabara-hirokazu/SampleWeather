package com.example.sampleweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleweather.model.WeeklyForecast

class WeatherViewModel : ViewModel() {

    private val _dailyForecast = MutableLiveData<WeeklyForecast>()
    val dailyForecast: LiveData<WeeklyForecast> = _dailyForecast

    fun onDateChanged(item: WeeklyForecast) {
        _dailyForecast.value = item
    }
}
