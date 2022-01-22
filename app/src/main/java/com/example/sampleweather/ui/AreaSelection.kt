package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleweather.R
import com.example.sampleweather.model.PokemonArea
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun AreaSelection(area: PokemonArea, onAreaChange: (PokemonArea) -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .clickable { expanded = !expanded },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "location",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
            )
            Text(
                text = stringResource(id = area.value),
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "dropdown",
                tint = Color.White
            )

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                PokemonArea.values().forEach { area ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        onAreaChange(area)
                    }) {
                        Text(text = stringResource(id = area.value))
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun AreaSelectionPreview() {
    SampleWeatherTheme {
        AreaSelection(PokemonArea.KANTO) {}
    }
}
