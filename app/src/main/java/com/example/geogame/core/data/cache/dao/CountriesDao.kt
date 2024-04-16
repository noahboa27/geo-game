package com.example.geogame.core.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.geogame.core.data.cache.model.LocalCountry

@Dao
interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(country: LocalCountry)

    @Query("SELECT * FROM countries WHERE name = :name LIMIT 1")
    suspend fun getCountryBy(name: String): LocalCountry

    @Query("SELECT * FROM countries ORDER BY RANDOM() LIMIT :numberOfCountries")
    suspend fun getRandomCountries(numberOfCountries: Int): List<LocalCountry>

}