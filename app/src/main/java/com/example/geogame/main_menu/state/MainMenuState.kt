package com.example.geogame.main_menu.state

sealed class MainMenuState {
    object Initial : MainMenuState()
    object Loading : MainMenuState()
}