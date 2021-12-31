package com.example.sampleweather.data

import com.example.sampleweather.R
import com.example.sampleweather.model.DailyForecast
import com.example.sampleweather.model.Forecast
import com.example.sampleweather.model.HourlyForecast

val WEEKLY_FORECAST = listOf(
    Forecast("1日(月)", "晴", R.drawable.sunny, 15, 26, 5),
    Forecast("2日(火)", "雨", R.drawable.rain, 11, 22, 85),
    Forecast("3日(水)", "雪", R.drawable.snow, 0, 10, 70),
    Forecast("4日(木)", "雷", R.drawable.thunder, 10, 20, 100),
    Forecast("5日(金)", "雨", R.drawable.rain, 9, 16, 90),
    Forecast("6日(土)", "晴", R.drawable.sunny, 13, 19, 10),
    Forecast("7日(日)", "雪", R.drawable.snow, 3, 8, 60)
)

val HOURLY_FORECASTS: List<HourlyForecast> =
    (0..23).map { hour ->
        HourlyForecast(hour, "雨", R.drawable.rain, 15, 60)
    }

val DAILY_FORECASTS: List<DailyForecast> =
    WEEKLY_FORECAST.map { DailyForecast(it.date, HOURLY_FORECASTS) }
