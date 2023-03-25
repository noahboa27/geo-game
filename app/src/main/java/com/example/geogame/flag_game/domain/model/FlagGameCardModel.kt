package com.example.geogame.flag_game.domain.model

import com.example.geogame.core.domain.model.Country

data class FlagGameCardModel(
    val answerCountry: Country,
    val otherCountries: List<Country>
)
