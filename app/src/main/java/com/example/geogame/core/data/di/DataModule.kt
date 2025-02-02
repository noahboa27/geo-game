package com.example.geogame.core.data.di

import com.example.geogame.core.data.cache.database.GeoGameDatabase
import com.example.geogame.core.data.repository.CountryFetchDateRepositoryImpl
import com.example.geogame.core.domain.repo.LocalCountryRepository
import com.example.geogame.core.data.repository.LocalCountryRepositoryImpl
import com.example.geogame.core.data.repository.RemoteCountryRepositoryImpl
import com.example.geogame.core.domain.repo.CountryFetchDateRepository
import com.example.geogame.core.domain.repo.RemoteCountryRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { GeoGameDatabase.getInstance(androidContext()) }
    single { get<GeoGameDatabase>().countryDao() }
    single { get<GeoGameDatabase>().countryFetchDateDao() }

    factory<CountryFetchDateRepository> { CountryFetchDateRepositoryImpl(get(), get()) }
    factory<LocalCountryRepository> { LocalCountryRepositoryImpl(get()) }
    factory<RemoteCountryRepository> { RemoteCountryRepositoryImpl(get(), get()) }
}