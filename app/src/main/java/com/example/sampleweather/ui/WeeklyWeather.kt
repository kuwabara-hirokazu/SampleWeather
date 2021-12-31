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
import com.example.sampleweather.data.WEEKLY_FORECAST
import com.example.sampleweather.extension.toDegreesString
import com.example.sampleweather.extension.toPercentString
import com.example.sampleweather.model.Forecast
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun WeeklyItem(modifier: Modifier = Modifier, forecast: Forecast) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp, 4.dp)) {
            Text(text = forecast.date, fontSize = 8.sp)
            Row(
                modifier = Modifier.padding(8.dp, 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = forecast.weatherIcon),
                    contentDescription = "Weather icon",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(text = forecast.weather)
            }
            Row {
                Text(text = forecast.minimumTemperature.toDegreesString())
                Text(text = stringResource(id = R.string.wavy_line))
                Text(text = forecast.maximumTemperature.toDegreesString())
            }
            Row(modifier = Modifier.padding(8.dp, 4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.umbrella),
                    contentDescription = "umbrella icon",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(text = forecast.chanceOfRain.toPercentString())
            }

        }
    }
}

@Composable
fun WeeklyWeather() {
    LazyRow(
        modifier = Modifier
            .background(Color.Blue)
            .padding(16.dp)
    ) {
        items(WEEKLY_FORECAST.size) { index ->
            WeeklyItem(
                modifier = Modifier.padding(8.dp),
                forecast = WEEKLY_FORECAST[index]
            )
        }
    }
}

@Preview
@Composable
fun WeeklyWeatherPreview() {
    SampleWeatherTheme {
        WeeklyWeather()
    }
}

