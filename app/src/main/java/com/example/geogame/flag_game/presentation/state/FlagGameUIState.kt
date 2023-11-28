package com.example.geogame.flag_game.presentation.state

import com.example.geogame.core.domain.model.FlagGameCountry

data class FlagGameUIState(
    val isFetchingCountries: Boolean = true,
    val countryLists: List<List<FlagGameCountry>> = listOf(),
    val userMessage: String = "",
    val finalScore: Int = 0,
    val countrySelected: (FlagGameCountry) -> Unit = {},
    val quitClicked: () -> Unit = {},
    val mainMenuClicked: () -> Unit = {}
)