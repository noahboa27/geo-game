package com.example.geogame.main_menu.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogame.main_menu.domain.useCase.GetRemoteCountriesUseCase
import com.example.geogame.main_menu.presentation.state.MainMenuState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainMenuViewModel(
    private val getRemoteCountriesUseCase: GetRemoteCountriesUseCase
): ViewModel() {

    private val _state = MutableStateFlow(MainMenuState())
    val state: StateFlow<MainMenuState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }

}