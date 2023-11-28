package com.example.geogame.flag_game.di

import com.example.geogame.flag_game.domain.usecases.GetRandomCountriesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetRandomCountriesUseCase(get()) }
}