package com.example.geogame.core.data.di

import coil3.ImageLoader
import coil3.SingletonImageLoader
import com.example.geogame.core.data.cache.database.GeoGameDatabase
import com.example.geogame.core.domain.repo.LocalCountryRepository
import com.example.geogame.core.data.repository.LocalCountryRepositoryImpl
import com.example.geogame.core.data.repository.RemoteCountryRepositoryImpl
import com.example.geogame.core.domain.repo.RemoteCountryRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { GeoGameDatabase.getInstance(androidContext()) }
    single {
        val database = get<GeoGameDatabase>()
        database.countryDao()
    }

    single {
        SingletonImageLoader.setSafe {
            ImageLoader.Builder(androidContext())
                .build()
        }
    }

    factory<LocalCountryRepository> { LocalCountryRepositoryImpl(get(), get()) }
    factory<RemoteCountryRepository> { RemoteCountryRepositoryImpl(get(), get()) }
}