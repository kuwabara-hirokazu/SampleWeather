package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.sampleweather.R
import com.example.sampleweather.data.DAILY_FORECASTS
import com.example.sampleweather.data.createPokemonData
import com.example.sampleweather.extension.toDegreesString
import com.example.sampleweather.extension.toHourString
import com.example.sampleweather.extension.toPercentString
import com.example.sampleweather.model.DailyForecast
import com.example.sampleweather.model.HourlyForecast
import com.example.sampleweather.ui.theme.SampleWeatherTheme
import kotlinx.coroutines.launch

@Composable
fun DailyItem(modifier: Modifier = Modifier, dailyForecast: DailyForecast) {
    Card(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Row {
            dailyForecast.forecasts.forEach { hourlyForecast ->
                HourlyItem(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    hourlyForecast = hourlyForecast
                )
            }
        }
    }
}

@Composable
fun HourlyItem(modifier: Modifier = Modifier, hourlyForecast: HourlyForecast) {
    Card(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = hourlyForecast.hour.toHourString(),
                color = Color.White,
                fontSize = 24.sp
            )
            Image(
                painter = painterResource(id = hourlyForecast.weatherIcon),
                contentDescription = "Weather icon",
                modifier = Modifier.size(300.dp)
            )
            Row {
                Image(
                    painter = painterResource(id = R.drawable.temperature),
                    contentDescription = "temperature icon",
                    modifier = Modifier.size(28.dp)
                )
                Text(
                    text = hourlyForecast.temperature.toDegreesString(),
                    color = Color.White,
                    fontSize = 28.sp
                )
                Spacer(Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.umbrella),
                    contentDescription = "umbrella icon",
                    modifier = Modifier.size(26.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = hourlyForecast.chanceOfRain.toPercentString(),
                    color = Color.White,
                    fontSize = 28.sp
                )
            }
            Spacer(Modifier.height(36.dp))
            Text(
                text = stringResource(id = R.string.pokemon_alert),
                color = Color.White,
                fontSize = 16.sp
            )
            Row {
                repeat(3) {
                    Image(
                        painter = rememberImagePainter(
                            data = createPokemonData()
                        ),
                        contentDescription = "pokemon icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun DailyWeather() {
    var count by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = stringResource(id = R.string.left_arrow),
                modifier = Modifier.clickable {
                    if (0 < count) {
                        count -= 1
                        coroutineScope.launch {
                            listState.scrollToItem(0)
                        }
                    }
                },
                fontSize = 28.sp,
                color = Color.White
            )
            Text(
                text = DAILY_FORECASTS[count].date,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            Text(
                text = stringResource(id = R.string.right_arrow),
                modifier = Modifier.clickable {
                    if (count < DAILY_FORECASTS.size - 1) {
                        count += 1
                        coroutineScope.launch {
                            listState.scrollToItem(0)
                        }
                    }
                },
                fontSize = 28.sp,
                color = Color.White
            )
        }
        LazyRow(state = listState) {
            items(1) {
                DailyItem(
                    modifier = Modifier.padding(8.dp),
                    dailyForecast = DAILY_FORECASTS[count]
                )
            }
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
