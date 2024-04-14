package com.example.geogame.flag_game.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.flag_game.domain.usecases.GetRandomCountriesUseCase
import com.example.geogame.flag_game.presentation.intent.FlagGameIntent
import com.example.geogame.flag_game.presentation.state.FlagGameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlagGameViewModel(
    private val getRandomCountries: GetRandomCountriesUseCase
) : ViewModel() {

    private val _flagGameState = MutableStateFlow(FlagGameState())
    val flagGameState = _flagGameState.asStateFlow()

    fun processIntent(intent: FlagGameIntent) {
        when (intent) {
            is FlagGameIntent.AnswerClicked -> processAnswer(intent.flagGameCountry)
            is FlagGameIntent.QuitClicked -> quitClicked()
            is FlagGameIntent.ShowResults -> showScore()
        }
    }

    private fun processAnswer(answer: FlagGameCountry) {
        // decide if the answer is correct or not, give feedback, and move to the next question
    }

    private fun quitClicked() {
        _flagGameState.update {
            it.copy(isQuiting = true)
        }
    }

    private fun showScore() {
        // show the final score
    }

    private fun quitGame() {
        // back to main menu
    }

//    fun getCountries() {
//        viewModelScope.launch {
//            _flagGameState.value = _flagGameState.value?.copy(
//                countries = getRandomCountries(40)
//            )
//        }
//    }
}