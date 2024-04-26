package com.example.geogame.core.navigation

import com.example.geogame.core.navigation.GeoGameNavActions
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val navModule = module {
    singleOf(::GeoGameNavActions)
}