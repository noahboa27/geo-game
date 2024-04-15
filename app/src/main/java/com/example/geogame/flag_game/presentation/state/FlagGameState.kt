package com.example.geogame.flag_game.presentation.state

import com.example.geogame.flag_game.presentation.QuestionSet

data class FlagGameState(
    val isLoading: Boolean = true,
    val currentQuestionSet: QuestionSet = QuestionSet(),
    val userMessage: String = "",
    val finalScore: Int = 0,
    val isQuiting: Boolean = false,
    val errorMessage: String = ""
)