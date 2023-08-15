package com.example.geogame.core.data.di

import com.example.geogame.core.data.cache.database.GeoGameDatabase
import com.example.geogame.core.domain.repo.CountryRepository
import com.example.geogame.core.data.repository.CountryRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { GeoGameDatabase.getInstance(androidContext()) }
    single {
        val database = get<GeoGameDatabase>()
        database.countryDao()
    }

    factory<CountryRepository> { CountryRepositoryImpl(get()) }
}