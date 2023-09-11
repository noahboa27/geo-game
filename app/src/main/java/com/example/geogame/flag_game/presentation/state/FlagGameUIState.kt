package com.example.geogame.flag_game.presentation.state

import com.example.geogame.core.domain.model.FlagGameCountry

data class FlagGameUIState(
    val isFetchingCountries: Boolean = true,
    val countryAnswerLists: List<List<FlagGameCountry>> = listOf(),
    val userMessage: String = "",
    val countrySelected: (FlagGameCountry) -> Unit = {},
    val quitClicked: () -> Unit = {}
)