package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleweather.R
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun WeatherScreen() {
    Image(
        painter = painterResource(id = R.drawable.img_background),
        contentDescription = "Weather image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )
        DailyWeather()
        WeeklyWeather()
    }
}

@Composable
@Preview
fun WeatherScreenPreview() {
    SampleWeatherTheme {
        WeatherScreen()
    }
}
