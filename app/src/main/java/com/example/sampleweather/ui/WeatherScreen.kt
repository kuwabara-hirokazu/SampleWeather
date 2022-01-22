package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleweather.R
import com.example.sampleweather.model.PokemonArea
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun WeatherScreen() {
    var checkedWeeklyState by remember { mutableStateOf(false) }
    var area by remember { mutableStateOf(PokemonArea.KANTO) }
    Image(
        painter = painterResource(id = R.drawable.img_background),
        contentDescription = "background image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        WeatherTitle(checkedWeeklyState) { checkedWeeklyState = it }
        AreaSelection(area) { area = it }
        when (checkedWeeklyState) {
            true -> WeeklyWeather(area = area)
            false -> DailyWeather(area = area)
        }
    }
}

@Composable
@Preview
fun WeatherScreenPreview() {
    SampleWeatherTheme {
        WeatherScreen()
    }
}
