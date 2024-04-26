package com.example.geogame.core.navigation

import androidx.navigation.NavHostController

class GeoGameNavActions(
    private val navController: NavHostController
) {
    fun navigateToMainMenu() {
        navController.navigate(Route.MainMenu.name)
    }

    fun navigateToFlagGame() {
        navController.navigate(Route.FlagGame.name)
    }
}