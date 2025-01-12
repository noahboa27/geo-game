package com.example.geogame.flag_game.presentation.intent

import com.example.geogame.core.domain.model.FlagGameCountry

sealed class FlagGameIntent {
    data class AnswerSelected(val flagGameCountry: FlagGameCountry) : FlagGameIntent()
    data object QuitClicked : FlagGameIntent()
    data object ShowResults : FlagGameIntent()
}