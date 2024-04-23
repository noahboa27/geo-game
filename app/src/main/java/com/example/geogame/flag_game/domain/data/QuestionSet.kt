package com.example.geogame.flag_game.domain.data

import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.core.domain.model.Name

data class QuestionSet(
    val index: Int = 0,
    val options: List<FlagGameCountry> = listOf(),
    val answer: FlagGameCountry = FlagGameCountry(flag = "", name = Name())
)
