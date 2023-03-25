package com.example.geogame.flag_game.di

import com.example.geogame.flag_game.domain.usecases.GetRandomCountries
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetRandomCountries(get()) }
}