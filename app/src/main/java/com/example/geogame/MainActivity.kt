package com.example.geogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.geogame.core.navigation.GeoGameNavGraph
import com.example.geogame.main_menu.presentation.viewModel.MainMenuViewModel
import com.example.geogame.ui.theme.CountryGameTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainMenuViewModel: MainMenuViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainMenuViewModel.mainMenuState.value.isLoading
            }
        }

        setContent {
            CountryGameTheme {
                GeoGameNavGraph()
            }
        }
    }
}