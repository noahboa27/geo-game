package com.example.geogame.flag_game.presentation

sealed class MainMenuState {
    object Initial : MainMenuState()
    object Loading : MainMenuState()
    data class Error(val errorMessage: String) : MainMenuState()
    object StartFlagGame : MainMenuState()
}