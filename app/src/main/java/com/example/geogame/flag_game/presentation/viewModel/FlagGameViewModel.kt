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
    var flagGameUiState by mutableStateOf(FlagGameUIState())
        private set
    private val countryList = getCountries()

    private fun getCountries() {
        viewModelScope.launch {
            getRandomCountriesUseCase(40).fold(
                onSuccess = {
                    flagGameUiState.copy(
                        countryLists = it.chunked(ANSWER_SET_SIZE)
                    )
                },
                onFailure = {
                    flagGameUiState.copy(
                        userMessage = it.localizedMessage ?: "fetching countries failed"
                    )
                }
            )
        }
    }

    companion object {
        const val ANSWER_SET_SIZE: Int = 4
    }
}