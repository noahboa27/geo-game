package com.example.geogame.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.geogame.flag_game.presentation.ui.FlagGameScoreScreen
import com.example.geogame.flag_game.presentation.ui.FlagGameScreen
import com.example.geogame.main_menu.presentation.ui.MainMenuScreen
import kotlinx.serialization.Serializable

@Serializable
object MainMenu
@Serializable
object FlagGame
@Serializable
data class FlagGameScore(val finalScore: Int)

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
                onFlagGameClicked = { navController.navigate(FlagGame) }
            )
        }

        composable<FlagGame> {
            FlagGameScreen(
                onQuitClicked = { navController.navigate(MainMenu) },
                onGameOver = { finalScore ->
                    navController.navigate(FlagGameScore(finalScore))
                }
            )
        }

        composable<FlagGameScore> {
            val args = it.toRoute<FlagGameScore>()
            FlagGameScoreScreen(
                flagGameScore = args.finalScore,
                onMainMenuClicked = { navController.navigate(MainMenu) }
            )
        }
    }
}