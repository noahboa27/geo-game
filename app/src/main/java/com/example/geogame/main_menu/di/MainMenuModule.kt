package com.example.geogame.main_menu.di

import com.example.geogame.main_menu.domain.useCase.GetRemoteCountriesUseCase
import com.example.geogame.main_menu.presentation.viewModel.MainMenuViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val mainMenuModule = module {
    factoryOf(::GetRemoteCountriesUseCase)
    viewModelOf(::MainMenuViewModel)
}