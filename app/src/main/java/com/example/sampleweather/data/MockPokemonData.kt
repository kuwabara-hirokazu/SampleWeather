package com.example.sampleweather.data

const val POKEMON_IMAGE =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

fun createPokemonData(): String {
    val pokemonGuideId = (1..386).random()
    return "${POKEMON_IMAGE + pokemonGuideId}.png"
}
