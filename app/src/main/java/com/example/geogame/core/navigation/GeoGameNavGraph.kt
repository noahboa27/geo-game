package com.example.geogame.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.geogame.flag_game.presentation.ui.FlagGameScoreScreen
import com.example.geogame.flag_game.presentation.ui.FlagGameScreen
import com.example.geogame.main_menu.presentation.ui.MainMenuScreen
import kotlinx.serialization.Serializable

@Serializable
object MainMenu
@Serializable
object FlagGame
@Serializable
object FlagGameScore

@Composable
fun GeoGameNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = MainMenu
    ) {
        composable<MainMenu> {
            MainMenuScreen(
                onFlagGameClicked = { navController.navigate(route = FlagGame) }
            )
        }
        composable<FlagGame> {
            FlagGameScreen(
                onQuitClicked = { navController.navigate(route = MainMenu) }
            )
        }
        composable<FlagGameScore> { backStackEntry ->
            val finalScore: Int = backStackEntry.arguments
            FlagGameScoreScreen(
                flagGameScore = finalScore,
                onMainMenuClicked = { navController.navigate(route = MainMenu) }
            )
        }
    }
}