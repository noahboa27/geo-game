package com.example.geogame.flag_game.presentation

import com.example.geogame.core.domain.model.Country

sealed class FlagGameState {
    object Initial : FlagGameState()
    object Loading : FlagGameState()
    data class Error(val errorMessage: String) : FlagGameState()
    data class Question(val countries: List<Country>, val correctCountry: Country) : FlagGameState()
    object GameOverResults : FlagGameState()
    object QuitGame : FlagGameState()
}
