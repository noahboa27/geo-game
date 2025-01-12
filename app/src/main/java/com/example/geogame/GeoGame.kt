package com.example.geogame

import android.app.Application
import com.example.geogame.core.coreKoinModule
import com.example.geogame.core.data.cache.database.GeoGameDatabase
import com.example.geogame.core.data.di.dataModule
import com.example.geogame.core.data.network.di.retrofitModule
import com.example.geogame.flag_game.di.flagGameModule
import com.example.geogame.main_menu.di.mainMenuModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GeoGame : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GeoGame)
            modules(
                coreKoinModule,
                dataModule,
                retrofitModule,
                mainMenuModule,
                flagGameModule
            )
        }

        GeoGameDatabase.getInstance(this)

//        // fetch for fresh data if need be
//        // new data will only come in once per month on app startup
//        CoroutineScope(Dispatchers.IO).launch {
//            val restCountriesApi: RestCountriesApi by inject()
//            val localCountryRepository: LocalCountryRepository by inject()
//
//            // i wonder how long this will take :D
//            restCountriesApi.getAllCountries().forEach {
//                localCountryRepository.insertCountry(CountryMapper.toLocal(it))
//            }
//        }
    }
}