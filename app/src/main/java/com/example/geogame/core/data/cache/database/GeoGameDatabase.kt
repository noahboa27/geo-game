package com.example.geogame.core.data.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geogame.core.data.cache.dao.CountriesDao
import com.example.geogame.core.data.cache.model.LocalCountry

@Database(
    entities = [LocalCountry::class],
    version = 1
)
abstract class GeoGameDatabase : RoomDatabase() {
    abstract fun countryDao(): CountriesDao

    companion object {
        private var instance: GeoGameDatabase? = null

        fun getInstance(context: Context): GeoGameDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    GeoGameDatabase::class.java,
                    "app_database"
                ).build().also {
                    instance = it
                }
            }
    }
}