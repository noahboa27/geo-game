package com.example.geogame.main_menu.state

sealed class MainMenuState {
    object Initial : MainMenuState()
    object Loading : MainMenuState()
    data class Error(val errorMessage: String) : MainMenuState()
    object StartFlagGame : MainMenuState()
}