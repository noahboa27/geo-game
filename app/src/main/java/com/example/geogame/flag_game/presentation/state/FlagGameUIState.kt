package com.example.geogame.flag_game.presentation.state

import com.example.geogame.core.domain.model.FlagGameCountry

data class FlagGameUIState(
    val isFetchingCountries: Boolean = true,
    val countries: List<FlagGameCountry> = listOf(),
    val userMessage: String = ""
)