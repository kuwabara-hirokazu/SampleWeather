package com.example.sampleweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleweather.model.WeatherItem

class WeatherViewModel: ViewModel() {

   private val _forecastImage = MutableLiveData<Int>()
    val forecastImage: LiveData<Int> = _forecastImage

    fun onForecastImageChange(weatherItem: WeatherItem) {
        _forecastImage.value = weatherItem.image
    }
}
