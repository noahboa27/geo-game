package com.example.geogame.flag_game.presentation.events

import com.example.geogame.core.domain.model.FlagGameCountry

sealed class FlagGameEvent {
    data class AnswerClicked(val flagGameCountry: FlagGameCountry) : FlagGameEvent()
    object QuitClicked : FlagGameEvent()
}