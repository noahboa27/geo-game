package com.example.geogame.flag_game.presentation

sealed class MainMenuState {
    object Initial : MainMenuState()
    object Loading : MainMenuState()
    object StartFlagGame : MainMenuState()
}