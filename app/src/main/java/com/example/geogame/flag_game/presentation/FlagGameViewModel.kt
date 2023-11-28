package com.example.geogame.flag_game.presentation

import androidx.lifecycle.ViewModel
import com.example.geogame.core.domain.model.Country
import com.example.geogame.flag_game.domain.usecases.GetRandomCountries
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FlagGameViewModel(
    private val getRandomCountries: GetRandomCountries
) : ViewModel() {
    private val _flagGameState = MutableStateFlow<FlagGameState>(FlagGameState.Initial)
    val flagGameState = _flagGameState.asStateFlow()

    fun processIntent(intent: FlagGameIntent) {
        when (intent) {
            is FlagGameIntent.AnswerClicked -> processAnswer(intent.country)
            is FlagGameIntent.QuitClicked -> quitClicked()
        }
    }

    private fun processAnswer(answer: Country) {
        // decide if the answer is correct or not, give feedback, and move to the next question
    }

    private fun quitClicked() {
        _flagGameState.value = FlagGameState.QuitGame
    }

//    fun getCountries() {
//        viewModelScope.launch {
//            _flagGameState.value = _flagGameState.value?.copy(
//                countries = getRandomCountries(40)
//            )
//        }
//    }
}