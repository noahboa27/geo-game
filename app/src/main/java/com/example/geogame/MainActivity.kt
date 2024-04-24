package com.example.geogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.geogame.core.navigation.GeoGameNavHost
import com.example.geogame.flag_game.presentation.viewModel.FlagGameViewModel
import com.example.geogame.main_menu.presentation.viewModel.MainMenuViewModel
import com.example.geogame.ui.theme.CountryGameTheme

class MainActivity : ComponentActivity() {

    private val mainMenuViewModel: MainMenuViewModel by viewModels()
    private val flagGameViewModel: FlagGameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainMenuViewModel.mainMenuState.value.isLoading
            }
        }

        setContent {
            CountryGameTheme {
                GeoGameNavHost()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CountryGameTheme {
        Greeting("Android")
    }
}