package com.example.geogame.flag_game.presentation.state

import com.example.geogame.core.domain.model.FlagGameCountry

data class FlagGameState(
    val isLoading: Boolean = true,
    val countryLists: List<List<FlagGameCountry>> = listOf(),
    val userMessage: String = "",
    val finalScore: Int = 0,
    val isQuiting: Boolean = false,
    val errorMessage: String = ""
)