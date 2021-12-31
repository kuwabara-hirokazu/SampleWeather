package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleweather.R
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun WeatherScreen() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.img_sunny),
            contentDescription = "Weather image",
            modifier = Modifier.fillMaxWidth().height(160.dp),
            contentScale = ContentScale.FillWidth
        )
        WeeklyWeather()
        DailyWeather()
    }
}

@Composable
@Preview
fun WeatherScreenPreview() {
    SampleWeatherTheme {
        WeatherScreen()
    }
}
