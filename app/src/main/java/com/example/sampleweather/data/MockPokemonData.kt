package com.example.sampleweather.data

import com.example.sampleweather.R

const val POKEMON_IMAGE =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

fun createPokemonData(): String {
    val pokemonGuideId = (1..386).random()
    return "${POKEMON_IMAGE + pokemonGuideId}.png"
}

enum class PokemonArea(val value: Int) {
    KANTO(R.string.kanto),
    JOHTO(R.string.johto),
    HOEEN(R.string.hoeen),
    SINNOH(R.string.sinnoh),
}
