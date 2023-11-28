package com.example.geogame.flag_game.presentation

import com.example.geogame.core.data.cache.model.LocalCountry

sealed class FlagGameIntent {
    data class AnswerClicked(val country: LocalCountry) : FlagGameIntent()
    object QuitClicked : FlagGameIntent()
}
