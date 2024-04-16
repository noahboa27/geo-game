package com.example.geogame

import android.app.Application
import com.example.geogame.core.coreKoinModule
import com.example.geogame.core.data.cache.database.GeoGameDatabase
import com.example.geogame.core.data.cache.model.LocalCountry
import com.example.geogame.core.data.di.dataModule
import com.example.geogame.core.data.mapper.CountryMapper
import com.example.geogame.core.data.network.api.RestCountriesApi
import com.example.geogame.core.data.network.di.retrofitModule
import com.example.geogame.core.domain.repo.CountryRepository
import com.example.geogame.flag_game.di.useCaseModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GeoGame : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GeoGame)
            modules(coreKoinModule, dataModule, retrofitModule, useCaseModule)
        }

        GeoGameDatabase.getInstance(this)

        // fetch for fresh data if need be
        // new data will only come in once per month on app startup
        CoroutineScope(Dispatchers.IO).launch {
            val restCountriesApi: RestCountriesApi by inject()
            val countryRepository: CountryRepository by inject()

            // i wonder how long this will take :D
            restCountriesApi.getAllCountries().forEach {
                countryRepository.insertCountry(CountryMapper.toLocal(it))
            }
        }
    }
}