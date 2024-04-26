package com.example.geogame.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.geogame.flag_game.presentation.ui.FlagGameScreen
import com.example.geogame.main_menu.presentation.ui.MainMenuScreen

@Composable
fun GeoGameNavGraph(
    navController: NavHostController = rememberNavController(),
    navActions: GeoGameNavActions = remember(navController) {
        GeoGameNavActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = Route.MainMenu.name
    ) {
        composable(Route.MainMenu.name) { MainMenuScreen() }
        composable(Route.FlagGame.name) { FlagGameScreen() }
    }
}