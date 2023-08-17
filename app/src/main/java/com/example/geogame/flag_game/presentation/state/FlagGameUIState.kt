package com.example.geogame.flag_game.presentation.state

import com.example.geogame.core.domain.model.Country

data class FlagGameUIState(
    val countries: List<Country>,
    val userMessage: String
)
