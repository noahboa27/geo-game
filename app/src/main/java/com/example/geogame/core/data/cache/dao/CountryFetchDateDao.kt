package com.example.geogame.core.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.geogame.core.data.cache.model.CountryFetchDate

@Dao
interface CountryFetchDateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(time: CountryFetchDate)

    @Query("SELECT lastFetchTime FROM countryFetchDate")
    suspend fun getLastFetchTime(): Long

}