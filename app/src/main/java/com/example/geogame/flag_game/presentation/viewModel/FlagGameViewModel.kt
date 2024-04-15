package com.example.geogame.flag_game.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.flag_game.domain.usecases.GetRandomCountriesUseCase
import com.example.geogame.flag_game.presentation.QuestionSet
import com.example.geogame.flag_game.presentation.intent.FlagGameIntent
import com.example.geogame.flag_game.presentation.state.FlagGameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class FlagGameViewModel(
    private val getRandomCountries: GetRandomCountriesUseCase
) : ViewModel() {

    private val questionSets: MutableList<QuestionSet> = mutableListOf()
    private val _flagGameState = MutableStateFlow(FlagGameState())
    val flagGameState = _flagGameState.asStateFlow()

    fun processIntent(intent: FlagGameIntent) {
        when (intent) {
            is FlagGameIntent.AnswerSelected -> processAnswer(intent.flagGameCountry)
            is FlagGameIntent.QuitClicked -> quitClicked()
            is FlagGameIntent.ShowResults -> showScore()
        }
    }

    private fun processAnswer(answer: FlagGameCountry) {
        // decide if the answer is correct or not

        // give feedback
        // move to the next question
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

    fun getCountries() {
        viewModelScope.launch {
            val countries = getRandomCountries(40)
            countries
                .onSuccess {
                    setAnswers(it)
                }
                .onFailure {
                    _flagGameState.update {
                        it.copy(errorMessage = "Something went wrong. Please try again.")
                    }
                }
        }
    }

    private fun setAnswers(countries: List<FlagGameCountry>) {
        val chunkedCountries = countries.chunked(4)
        chunkedCountries.forEach {
            val randomNum = Random.nextInt(0, 4)
            val setOfQuestions = QuestionSet(
                countryOptions = it,
                answer = it[randomNum]
            )
            questionSets.add(setOfQuestions)
        }

        _flagGameState.update {
            it.copy(currentQuestionSet = questionSets.first())
        }
    }
}