package com.example.sampleweather.data

import com.example.sampleweather.model.PokemonArea

class MockPokemonManager {
    companion object {
        const val POKEMON_IMAGE =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"
    }

    fun getDailyPokemonData(area: PokemonArea): List<String> {
        return (1..(24 * 7 * 3)).map {
            createPokemonData(area)
        }
    }

    fun getWeeklyPokemonData(area: PokemonArea): List<String> {
        return (1..(7 * 3)).map {
            createPokemonData(area)
        }
    }

    private fun createPokemonData(area: PokemonArea): String {
        val pokemonGuideId = when (area) {
            PokemonArea.KANTO -> (1..151).random()
            PokemonArea.JOHTO -> (152..251).random()
            PokemonArea.HOEEN -> (251..386).random()
            PokemonArea.SINNOH -> (387..493).random()
        }
        return "${POKEMON_IMAGE + pokemonGuideId}.png"
    }
}
