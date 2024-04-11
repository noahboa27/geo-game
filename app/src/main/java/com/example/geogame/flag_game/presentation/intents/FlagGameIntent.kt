package com.example.geogame.flag_game.presentation.intents

import com.example.geogame.core.domain.model.FlagGameCountry

sealed class FlagGameIntent {
    data class AnswerClicked(val flagGameCountry: FlagGameCountry) : FlagGameIntent()
    object QuitClicked : FlagGameIntent()
    object MainMenuClicked : FlagGameIntent()
}