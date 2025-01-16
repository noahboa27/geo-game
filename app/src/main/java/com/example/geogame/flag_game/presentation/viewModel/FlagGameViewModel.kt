package com.example.geogame.flag_game.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.ImageLoader
import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.flag_game.domain.useCase.GetRandomCountriesUseCase
import com.example.geogame.flag_game.domain.data.QuestionSet
import com.example.geogame.flag_game.presentation.state.FlagGameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class FlagGameViewModel(
    private val getRandomCountries: GetRandomCountriesUseCase,
    private val imageLoader: ImageLoader
) : ViewModel() {

    private val _flagGameState = MutableStateFlow(FlagGameState())
    val flagGameState = _flagGameState.asStateFlow()

    fun processAnswer(userAnswer: FlagGameCountry) {
        // decide if the answer is correct or not
        if (userAnswer == _flagGameState.value.currentQuestionSet.answer) {
            _flagGameState.update {
                it.copy(score = it.score + 1)
            }
        }
        // give feedback?

        // need to check if we reached the end before incrementing

        // move to the next question
        _flagGameState.update {
            it.copy(currentQuestionSet = it.questionSets[it.currentQuestionSet.index + 1])
        }
    }

    fun getCountries() {
        viewModelScope.launch {
            val countries = getRandomCountries(40)
            countries
                .onSuccess {
                    setAnswers(it)
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

    private fun setAnswers(countries: List<FlagGameCountry>) {
        val chunkedCountries = countries.chunked(4)
        val questions: MutableList<QuestionSet> = mutableListOf()
        chunkedCountries.forEachIndexed { index, flagGameCountries ->
            val randomNum = Random.nextInt(0, 4)
            val questionSet = QuestionSet(
                index = index,
                options = flagGameCountries,
                answer = flagGameCountries[randomNum]
            )
            questions.add(questionSet)
        }

        _flagGameState.update {
            it.copy(
                questionSets = questions,
                currentQuestionSet = questions.first()
            )
        }
    }
}