package com.example.geogame.main_menu.presentation

sealed class MainMenuIntent {
    object StartFlagGame: MainMenuIntent()
    object SettingsClicked: MainMenuIntent()
}