package com.example.geogame.flag_game.presentation.state

import com.example.geogame.flag_game.domain.data.QuestionSet

data class FlagGameState(
    val isLoading: Boolean = true,
    val questions: List<QuestionSet> = listOf(),
    val currentQuestion: QuestionSet = QuestionSet(),
    val userMessage: String = "",
    val score: Int = 0,
    val isQuiting: Boolean = false,
    val errorMessage: String = ""
)