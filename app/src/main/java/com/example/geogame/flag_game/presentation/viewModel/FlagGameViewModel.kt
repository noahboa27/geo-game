package com.example.geogame.flag_game.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geogame.flag_game.domain.usecases.GetRandomCountriesUseCase
import com.example.geogame.flag_game.presentation.state.FlagGameState

class FlagGameViewModel(
    private val getRandomCountriesUseCase: GetRandomCountriesUseCase
) : ViewModel() {
    private val _flagGameState = MutableLiveData<FlagGameState>()
    val flagGameState: LiveData<FlagGameState> get() = _flagGameState

//    fun getCountries() {
//        viewModelScope.launch {
//            _flagGameState.value = _flagGameState.value?.copy(
//                countries = getRandomCountries(40)
//            )
//        }
//    }
}