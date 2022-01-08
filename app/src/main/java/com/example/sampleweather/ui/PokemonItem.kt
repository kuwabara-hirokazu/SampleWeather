package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import com.example.sampleweather.data.createPokemonData

@Composable
fun PokemonItem(modifier: Modifier) {
    Image(
        painter = rememberImagePainter(
            data = createPokemonData()
        ),
        contentDescription = "pokemon icon",
        modifier = modifier
    )
}
