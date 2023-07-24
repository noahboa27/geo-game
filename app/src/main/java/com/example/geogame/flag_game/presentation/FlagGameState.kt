package com.example.geogame.flag_game.presentation

import com.example.geogame.core.domain.model.Country

sealed class FlagGameState {
    object Initial : FlagGameState()
    object IsLoading : FlagGameState()
    data class Question(val countries: List<Country>, val correctCountry: Country) : FlagGameState()
    object AnswerCorrect : FlagGameState()
    object AnswerIncorrect : FlagGameState()
    object GameOverResults : FlagGameState()
    object GameOverForced : FlagGameState()
}
