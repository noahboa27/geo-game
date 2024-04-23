package com.example.geogame

import androidx.lifecycle.ViewModel
import com.example.geogame.main_menu.domain.useCase.GetRemoteCountriesUseCase

class MainActivityViewModel(
    private val getRemoteCountriesUseCase: GetRemoteCountriesUseCase
): ViewModel() {

}