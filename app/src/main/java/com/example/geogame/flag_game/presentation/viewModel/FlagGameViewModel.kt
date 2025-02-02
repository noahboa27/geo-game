package com.example.geogame.flag_game.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogame.flag_game.domain.data.FlagGameCountry
import com.example.geogame.flag_game.domain.useCase.GetRandomCountriesUseCase
import com.example.geogame.flag_game.presentation.state.FlagGameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class FlagGameViewModel(
    private val getRandomCountries: GetRandomCountriesUseCase
) : ViewModel() {

    private val _flagGameState = MutableStateFlow(FlagGameState())
    val flagGameState = _flagGameState.asStateFlow()

    init {
        getCountries()
    }

    fun processAnswer(isAnswer: Boolean) {
        if (isAnswer) {
            _flagGameState.update {
                it.copy(score = it.score + 1)
            }
        }

        // check if we reached the end before incrementing
        if (flagGameState.value.currentQuestionNumber + 1 > flagGameState.value.numberOfQuestions) {
            _flagGameState.update {
                it.copy(isGameOver = true)
            }
        } else {
            //TODO
            // give some sort of user feedback

            // increment progress
            _flagGameState.update {
                it.copy(currentQuestionNumber = it.currentQuestionNumber + 1)
            }

            val answer = _flagGameState.value.currentQuestion.find { it.isAnswer }
            val answerIndex = _flagGameState.value.currentQuestion.indexOf(answer)
            _flagGameState.update {
                it.copy(
                    currentQuestion = it.questions[it.currentQuestionNumber - 1],
                    answerIndex = answerIndex
                )
            }
        }
    }

    fun doneLoading() {
        _flagGameState.update {
            it.copy(isLoading = false)
        }
    }

    private fun getCountries() {
        viewModelScope.launch {
            val countries = getRandomCountries(40)
            countries
                .onSuccess {
                    setupFlagGame(it)
                }
                .onFailure { e ->
                    Log.e(this.javaClass.name, e.message ?: "Error fetching countries from Room")
                    // most likely this will just be an error dialog or similar
                    _flagGameState.update {
                        it.copy(errorMessage = "Something went wrong. Please try again.")
                    }
                }
        }
    }

    private fun setupFlagGame(countries: List<FlagGameCountry>) {
        val chunkedCountries = countries.chunked(4)
        val questions: MutableList<List<FlagGameCountry>> = mutableListOf()
        var answerIndex = 0
        chunkedCountries.forEachIndexed { index, flagGameCountrySet ->
            answerIndex = Random.nextInt(0, 4)
            flagGameCountrySet[answerIndex].isAnswer = true
            questions.add(index, flagGameCountrySet)
        }
        setProgressBarValues(questions.size)

        _flagGameState.update {
            it.copy(
                questions = questions,
                currentQuestion = questions[0],
                answerIndex = answerIndex,
                numberOfQuestions = questions.size,
                isLoading = false
            )
        }
    }

    private fun setProgressBarValues(
        numOfQuestions: Int
    ) {
        val values = FloatArray(10)
        val denominator = numOfQuestions.toFloat()
        for (i in 1..numOfQuestions) {
            values[i - 1] = i / denominator
        }
        _flagGameState.update {
            it.copy(progression = values)
        }
    }
}