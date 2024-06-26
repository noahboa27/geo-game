package com.example.geogame.main_menu.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogame.core.navigation.GeoGameNavActions
import com.example.geogame.main_menu.domain.useCase.GetRemoteCountriesUseCase
import com.example.geogame.main_menu.presentation.intent.MainMenuIntent
import com.example.geogame.main_menu.presentation.state.MainMenuState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainMenuViewModel(
    private val navActions: GeoGameNavActions,
    private val getRemoteCountriesUseCase: GetRemoteCountriesUseCase
): ViewModel() {

    private val _mainMenuState = MutableStateFlow(MainMenuState())
    val mainMenuState: StateFlow<MainMenuState> = _mainMenuState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _mainMenuState.update {
                it.copy(isLoading = false)
            }
        }
    }

    fun processIntent(intent: MainMenuIntent) {
        when (intent) {
            MainMenuIntent.SettingsClicked -> Unit
            MainMenuIntent.StartFlagGame -> navActions.navigateToMainMenu()
        }
    }

}