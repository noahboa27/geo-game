package com.example.geogame.flag_game.presentation.state

sealed class FlagGameState {
    object Initial : FlagGameState()
    object IsLoading : FlagGameState()
    object DoneLoading : FlagGameState()
}