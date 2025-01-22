package com.example.geogame.core.data.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.geogame.core.data.cache.converter.Converters
import com.example.geogame.core.data.cache.dao.CountriesDao
import com.example.geogame.core.data.cache.dao.CountryFetchDateDao
import com.example.geogame.core.data.cache.model.CountryFetchDate
import com.example.geogame.core.data.cache.model.LocalCountry

@Database(
    entities = [
        LocalCountry::class,
        CountryFetchDate::class
               ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class GeoGameDatabase : RoomDatabase() {
    abstract fun countryDao(): CountriesDao
    abstract fun countryFetchDateDao(): CountryFetchDateDao

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