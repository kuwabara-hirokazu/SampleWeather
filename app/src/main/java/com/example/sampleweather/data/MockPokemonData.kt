package com.example.sampleweather.data

import com.example.sampleweather.R

const val POKEMON_IMAGE =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

fun createPokemonData(area: PokemonArea): String {
    val pokemonGuideId = when (area) {
        PokemonArea.KANTO -> (1..151).random()
        PokemonArea.JOHTO -> (152..251).random()
        PokemonArea.HOEEN -> (251..386).random()
        PokemonArea.SINNOH -> (387..493).random()
    }
    return "${POKEMON_IMAGE + pokemonGuideId}.png"
}

enum class PokemonArea(val value: Int) {
    KANTO(R.string.kanto),
    JOHTO(R.string.johto),
    HOEEN(R.string.hoeen),
    SINNOH(R.string.sinnoh),
}
