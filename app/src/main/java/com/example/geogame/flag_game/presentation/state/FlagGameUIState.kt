package com.example.geogame.flag_game.presentation.state

import com.example.geogame.core.domain.model.Country

data class FlagGameUIState(
    val isFetchingCountries: Boolean = true,
    val countries: List<Country> = listOf(),
    val userMessage: String = ""
)