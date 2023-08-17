package com.example.geogame.flag_game.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogame.flag_game.domain.usecases.GetRandomCountriesUseCase
import com.example.geogame.flag_game.presentation.state.FlagGameUIState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FlagGameViewModel(
    private val getRandomCountriesUseCase: GetRandomCountriesUseCase
) : ViewModel() {
    var flagGameState by mutableStateOf(FlagGameUIState())
        private set
    private var fetchJob: Job? = null

    fun getCountries() {
        fetchJob?.cancel()
        viewModelScope.launch {
            try {
                flagGameState = flagGameState.copy(
                    countries = getRandomCountriesUseCase(40)
                )
            } catch (t: Throwable) {
                flagGameState = flagGameState.copy(
                    userMessage = t.localizedMessage ?: "fetching countries failed"
                )
            }
        }
    }
}