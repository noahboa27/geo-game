package com.example.geogame.flag_game.di

import com.example.geogame.flag_game.domain.useCase.GetRandomCountriesUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val flagGameModule = module {
    factoryOf(::GetRandomCountriesUseCase)
}