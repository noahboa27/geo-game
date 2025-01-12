package com.example.geogame.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object MainMenu

@Composable
fun GeoGameNavGraph(
    navController: NavHostController = rememberNavController()
) {
//    NavHost(
//        navController = navController,
//        startDestination = Route.MainMenu.name
//    ) {
//        composable(Route.MainMenu.name) { MainMenuScreen() }
//        composable(Route.FlagGame.name) { FlagGameScreen() }
//    }
}