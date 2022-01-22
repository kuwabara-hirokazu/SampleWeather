package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleweather.R
import com.example.sampleweather.model.PokemonArea
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val checkedWeeklyState by viewModel.isWeeklyState.observeAsState(false)
    val area by viewModel.pokemonArea.observeAsState(PokemonArea.KANTO)
    val weeklyForecasts by viewModel.weeklyForecasts.observeAsState(listOf())
    val dailyForecasts by viewModel.dailyForecasts.observeAsState(listOf())
    val pokemonData by viewModel.pokemonData.observeAsState(listOf())

    Image(
        painter = painterResource(id = R.drawable.img_background),
        contentDescription = "background image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        WeatherTitle(checkedWeeklyState) {
            viewModel.onStateChange(it)
            viewModel.getWeatherData(area)
        }
        AreaSelection(area) {
            viewModel.onAreaChange(it)
            viewModel.getWeatherData(area)
        }
        if (pokemonData.isNotEmpty()) {
            when (checkedWeeklyState) {
                true -> WeeklyWeather(
                    forecast = weeklyForecasts,
                    pokemonData = pokemonData,
                )
                false -> DailyWeather(
                    forecasts = dailyForecasts,
                    pokemonData = pokemonData
                )
            }
        }
    }
}

@Composable
@Preview
fun WeatherScreenPreview() {
    SampleWeatherTheme {
        WeatherScreen(WeatherViewModel())
    }
}
