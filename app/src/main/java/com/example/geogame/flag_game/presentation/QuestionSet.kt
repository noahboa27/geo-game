package com.example.geogame.flag_game.presentation

import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.core.domain.model.Name

data class QuestionSet(
    val countryList: List<FlagGameCountry> = listOf(),
    val answer: FlagGameCountry = FlagGameCountry(flag = "", name = Name())
)
