package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleweather.R
import com.example.sampleweather.data.DAILY_FORECASTS
import com.example.sampleweather.extension.toDegreesString
import com.example.sampleweather.extension.toHourString
import com.example.sampleweather.extension.toPercentString
import com.example.sampleweather.model.DailyForecast
import com.example.sampleweather.model.HourlyForecast
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun DailyItem(modifier: Modifier = Modifier, dailyForecast: DailyForecast) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp, 4.dp)) {
            Text(text = dailyForecast.date, fontSize = 16.sp)
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                dailyForecast.forecasts.forEach { hourlyForecast ->
                    HourlyItem(
                        modifier = Modifier.padding(8.dp),
                        hourlyForecast = hourlyForecast
                    )
                }
            }
        }
    }
}

@Composable
fun HourlyItem(modifier: Modifier = Modifier, hourlyForecast: HourlyForecast) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.LightGray
    ) {
        Column(
            modifier = Modifier.padding(8.dp, 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = hourlyForecast.hour.toHourString(), fontSize = 12.sp)
            Row(modifier = Modifier.padding(8.dp, 4.dp)) {
                Image(
                    painter = painterResource(id = hourlyForecast.weatherIcon),
                    contentDescription = "Weather icon",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(text = stringResource(id = hourlyForecast.weather))
            }
            Text(text = hourlyForecast.temperature.toDegreesString())
            Row(modifier = Modifier.padding(8.dp, 4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.umbrella),
                    contentDescription = "umbrella icon",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(text = hourlyForecast.chanceOfRain.toPercentString())
            }
        }
    }
}

@Composable
fun DailyWeather() {
    LazyRow(
        modifier = Modifier
            .background(Color.Blue)
            .padding(16.dp)
    ) {
        items(DAILY_FORECASTS.size) { index ->
            DailyItem(
                modifier = Modifier.padding(8.dp),
                dailyForecast = DAILY_FORECASTS[index]
            )
        }
    }
}

@Preview
@Composable
fun DailyWeatherPreview() {
    SampleWeatherTheme {
        DailyWeather()
    }
}
