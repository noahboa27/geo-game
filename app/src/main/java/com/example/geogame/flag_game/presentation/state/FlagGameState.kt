package com.example.geogame.flag_game.presentation.state

import com.example.geogame.flag_game.domain.data.QuestionSet

data class FlagGameState(
    val isLoading: Boolean = true,
    val questionSets: List<QuestionSet> = listOf(),
    val currentQuestionSet: QuestionSet = QuestionSet(),
    val userMessage: String = "",
    val questionsCompleted: Int = 0,
    val totalQuestionSets: Int = 0,
    val progression: Float = 0.0.toFloat(),
    val score: Int = 0,
    val isQuiting: Boolean = false,
    val errorMessage: String = ""
)