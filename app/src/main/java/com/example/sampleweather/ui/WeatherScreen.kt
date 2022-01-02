package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleweather.data.WEEKLY_FORECAST
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val forecastImage by viewModel.forecastImage.observeAsState(WEEKLY_FORECAST[0].weather.image)

    Column {
        Image(
            painter = painterResource(id = forecastImage),
            contentDescription = "Weather image",
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentScale = ContentScale.FillWidth
        )
        WeeklyWeather { viewModel.onForecastImageChanged(it) }
        DailyWeather()
    }
}

@Composable
@Preview
fun WeatherScreenPreview() {
    SampleWeatherTheme {
        WeatherScreen(WeatherViewModel())
    }
}
