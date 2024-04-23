package com.example.geogame.main_menu.presentation.state

data class MainMenuState(
    val isLoading: Boolean = true,
    val userMessage: String = "",
    val errorMessage: String = ""
)