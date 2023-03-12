package com.example.geogame.core.di

import com.example.geogame.core.data.cache.database.AppDatabase
import com.example.geogame.core.repository.CountryRepository
import com.example.geogame.core.repository.impl.CountryRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule = module {
    single { AppDatabase.getInstance(androidContext()) }
    single {
        val database = get<AppDatabase>()
        database.countryDao()
    }

    factory<CountryRepository> { CountryRepositoryImpl(get()) }
}