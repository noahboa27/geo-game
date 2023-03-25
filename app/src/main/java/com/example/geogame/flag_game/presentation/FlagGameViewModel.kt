package com.example.geogame.flag_game.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geogame.flag_game.domain.usecases.GetRandomCountries
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FlagGameViewModel(
    private val coroutineScope: CoroutineScope,
    private val getRandomCountries: GetRandomCountries
) : ViewModel() {
    private val _flagGameState = MutableLiveData(FlagGameState())
    val flagGameState get() = _flagGameState

    init {
        getCountries()
    }

    fun getCountries() {
        coroutineScope.launch {
            _flagGameState.value = _flagGameState.value?.copy(
                countries = getRandomCountries(20)
            )
        }
    }
}