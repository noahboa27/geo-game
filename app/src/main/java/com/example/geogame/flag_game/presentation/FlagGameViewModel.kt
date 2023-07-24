package com.example.geogame.flag_game.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogame.flag_game.domain.usecases.GetRandomCountries
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FlagGameViewModel(
    private val getRandomCountries: GetRandomCountries
) : ViewModel() {
    private val _flagGameState = MutableLiveData<FlagGameState>()
    val flagGameState: LiveData<FlagGameState> get() = _flagGameState

    fun processIntent(intent: FlagGameIntent) {

    }

//    fun getCountries() {
//        viewModelScope.launch {
//            _flagGameState.value = _flagGameState.value?.copy(
//                countries = getRandomCountries(40)
//            )
//        }
//    }
}