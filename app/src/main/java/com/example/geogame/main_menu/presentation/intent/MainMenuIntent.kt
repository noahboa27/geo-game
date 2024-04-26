package com.example.geogame.main_menu.presentation.intent

sealed class MainMenuIntent {
    object StartFlagGame: MainMenuIntent()
    object SettingsClicked: MainMenuIntent()
}