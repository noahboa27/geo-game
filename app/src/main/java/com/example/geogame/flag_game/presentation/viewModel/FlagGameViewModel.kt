package com.example.geogame.flag_game.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogame.flag_game.domain.usecases.GetRandomCountriesUseCase
import com.example.geogame.flag_game.presentation.state.FlagGameUIState
import kotlinx.coroutines.launch

class FlagGameViewModel(
    private val getRandomCountriesUseCase: GetRandomCountriesUseCase
) : ViewModel() {
    var flagGameState by mutableStateOf(FlagGameUIState())
        private set

    fun getCountries() {
        viewModelScope.launch {
            getRandomCountriesUseCase(40).fold(
                onSuccess = {
                    flagGameState.copy(
                        countries = it
                    )
                },
                onFailure = {
                    flagGameState.copy(
                        userMessage = it.localizedMessage ?: "fetching countries failed"
                    )
                }
            )
        }
    }
}