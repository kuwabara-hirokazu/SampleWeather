package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var checkedWeeklyState by remember { mutableStateOf(false) }
    Image(
        painter = painterResource(id = R.drawable.img_background),
        contentDescription = "background image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                fontSize = 32.sp,
                modifier = Modifier.padding(end = 16.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.pokemon_ball),
                contentDescription = "pokemon ball",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { checkedWeeklyState = !checkedWeeklyState }
            )
        }
        when (checkedWeeklyState) {
            true -> WeeklyWeather()
            false -> DailyWeather()
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
