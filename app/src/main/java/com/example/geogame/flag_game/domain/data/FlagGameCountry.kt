package com.example.geogame.flag_game.domain.data

data class FlagGameCountry(
    val flagUrl: String,   // url used to get the flag image using Coil
    val name: String,
    var isAnswer: Boolean
)