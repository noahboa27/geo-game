package com.example.geogame.flag_game.di

import com.example.geogame.flag_game.domain.useCase.GetRandomCountriesUseCase
import com.example.geogame.flag_game.presentation.viewModel.FlagGameViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val flagGameModule = module {
    factoryOf(::GetRandomCountriesUseCase)
    viewModelOf(::FlagGameViewModel)

//    single {
//        SingletonImageLoader.setSafe {
//            ImageLoader.Builder(androidContext())
//                .build()
//        }
//    }
}