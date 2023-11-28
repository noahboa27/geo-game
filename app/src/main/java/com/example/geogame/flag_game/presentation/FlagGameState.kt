package com.example.geogame.flag_game.presentation

import com.example.geogame.core.data.cache.model.LocalCountry

sealed class FlagGameState {
    object Initial : FlagGameState()
    object Loading : FlagGameState()
    data class Error(val errorMessage: String) : FlagGameState()
    data class Question(val countries: List<LocalCountry>, val correctCountry: LocalCountry) : FlagGameState()
    object GameOverResults : FlagGameState()
    object QuitGame : FlagGameState()
}
