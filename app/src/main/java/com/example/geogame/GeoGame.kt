package com.example.geogame

import android.app.Application
import com.example.geogame.core.coreKoinModule
import com.example.geogame.core.data.di.dataModule
import com.example.geogame.core.data.network.di.retrofitModule
import com.example.geogame.flag_game.di.useCaseModule
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

        // Probably get the countries here?
        // Create db and store them
    }
}