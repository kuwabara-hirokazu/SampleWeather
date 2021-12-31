package com.example.sampleweather.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.sampleweather.R

@Composable fun Int.toDegreesString(): String {
    return stringResource(id = R.string.degrees, this.toString())
}

@Composable fun Int.toPercentString(): String {
    return stringResource(id = R.string.percent, this.toString())
}

@Composable fun Int.toHourString(): String {
    return stringResource(id = R.string.hour, this.toString())
}
