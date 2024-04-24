package com.example.geogame.core.navigation

sealed class Route(val name: String) {
    object MainMenu: Route("main_menu")
    object FlagGame: Route("flag_game")
}