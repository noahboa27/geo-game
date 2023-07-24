package com.example.geogame.flag_game.presentation

sealed class FlagGameSideEffect {
    object NextQuestion : FlagGameSideEffect()
    object MainMenu : FlagGameSideEffect()
}
