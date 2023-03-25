package com.example.geogame.flag_game.presentation

import com.example.geogame.core.domain.model.Country

data class FlagGameState(
    val isLoading: Boolean = false,
    val countries: List<Country> = listOf(),
    val errorMessage: String = ""
)
