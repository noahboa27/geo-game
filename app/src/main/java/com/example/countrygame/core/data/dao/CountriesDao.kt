package com.example.countrygame.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.countrygame.core.data.model.Country

@Dao
interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg countries: Country)

    @Query("SELECT * FROM countries WHERE name = :name LIMIT 1")
    suspend fun getCountryBy(name: String): Country

    @Query("SELECT * FROM countries ORDER BY RANDOM() LIMIT :numberOfCountries")
    suspend fun getRandomCountries(numberOfCountries: Int): List<Country>

}