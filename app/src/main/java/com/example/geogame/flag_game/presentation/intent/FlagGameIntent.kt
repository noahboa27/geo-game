package com.example.geogame.flag_game.presentation.intent

import com.example.geogame.core.domain.model.FlagGameCountry

sealed class FlagGameIntent {
    data class AnswerClicked(val flagGameCountry: FlagGameCountry) : FlagGameIntent()
    object QuitClicked : FlagGameIntent()
    object ShowResults : FlagGameIntent()

    // probably don't need these
//    object NextQuestion : FlagGameIntent()
//    object AnswerCorrect : FlagGameIntent()
//    object AnswerIncorrect : FlagGameIntent()
}