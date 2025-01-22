package com.example.geogame

import android.app.Application
import com.example.geogame.core.coreKoinModule
import com.example.geogame.core.data.cache.database.GeoGameDatabase
import com.example.geogame.core.data.cache.model.CountryFetchDate
import com.example.geogame.core.data.di.dataModule
import com.example.geogame.core.data.mapper.CountryMapper
import com.example.geogame.core.data.network.api.RestCountriesApi
import com.example.geogame.core.data.network.di.retrofitModule
import com.example.geogame.core.domain.repo.CountryFetchDateRepository
import com.example.geogame.core.domain.repo.LocalCountryRepository
import com.example.geogame.flag_game.di.flagGameModule
import com.example.geogame.main_menu.di.mainMenuModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.Date

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

        GeoGameDatabase.getInstance(applicationContext)

        // fetch for fresh data if need be
        // new data will only come in once per month on app startup
        CoroutineScope(Dispatchers.IO).launch {
            val countryFetchDateRepository: CountryFetchDateRepository by inject()
            val currentTime = Date().time
            val lastFetch = countryFetchDateRepository.getLastFetchTime()
            val oneWeekFromLastFetch = lastFetch + WEEK_IN_MILLISECONDS

            if (lastFetch == ZERO) {
                countryFetchDateRepository.insert(CountryFetchDate(lastFetchTime = lastFetch))
            }

            if (currentTime > oneWeekFromLastFetch) {
                val restCountriesApi: RestCountriesApi by inject()
                val localCountryRepository: LocalCountryRepository by inject()

                // i wonder how long this will take :D
//                restCountriesApi.getAllCountries().forEach {
//                    localCountryRepository.insertCountry(CountryMapper.toLocal(it))
//                }
            }
        }
    }

    companion object {
        const val ZERO: Long = 0
        const val WEEK_IN_MILLISECONDS: Long = 604_800_000
    }
}