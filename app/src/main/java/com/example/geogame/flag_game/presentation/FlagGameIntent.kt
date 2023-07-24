package com.example.geogame.flag_game.presentation

import com.example.geogame.core.domain.model.Country

sealed class FlagGameIntent {
    data class AnswerClicked(val country: Country) : FlagGameIntent()
    object QuitClicked : FlagGameIntent()
    object MainMenuClicked : FlagGameIntent()
}
