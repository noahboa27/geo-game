package com.example.geogame.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geogame.core.data.dao.CountriesDao
import com.example.geogame.core.data.model.Country

@Database(
    entities = [Country::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountriesDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build().also {
                    instance = it
                }
            }
    }
}