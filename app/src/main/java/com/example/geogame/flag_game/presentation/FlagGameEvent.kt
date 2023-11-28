package com.example.geogame.flag_game.presentation

sealed class FlagGameEvent {
    object NextQuestion : FlagGameEvent()
    object AnswerCorrect : FlagGameEvent()
    object AnswerIncorrect : FlagGameEvent()
}
