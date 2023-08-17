package com.example.geogame.flag_game.presentation.events

import com.example.geogame.core.domain.model.Country

sealed class FlagGameEvent {
    data class AnswerClicked(val country: Country) : FlagGameEvent()
    object QuitClicked : FlagGameEvent()
}