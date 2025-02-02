package com.example.geogame.flag_game.presentation.state

import com.example.geogame.flag_game.domain.data.FlagGameCountry

data class FlagGameState(
    val isLoading: Boolean = true,
    val questions: List<List<FlagGameCountry>> = listOf(),
    val currentQuestion: List<FlagGameCountry> = listOf(),
    val currentQuestionNumber: Int = 1,
    val numberOfQuestions: Int = 0,
    val progression: FloatArray = floatArrayOf(),
    val answerIndex: Int = 0,
    val score: Int = 0,
    val isQuiting: Boolean = false,
    val isGameOver: Boolean = false,
    val userMessage: String = "",
    val errorMessage: String = ""
)