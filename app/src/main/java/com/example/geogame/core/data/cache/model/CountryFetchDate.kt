package com.example.geogame.core.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countryFetchDate")
data class CountryFetchDate(
    @PrimaryKey val id: Int = 0,
    val lastFetchTime: Long
)
