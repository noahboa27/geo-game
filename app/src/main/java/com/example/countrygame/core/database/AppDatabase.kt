package com.example.countrygame.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.countrygame.core.data.dao.CountriesDao
import com.example.countrygame.core.data.model.Country

@Database(
    entities = [Country::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountriesDao
}