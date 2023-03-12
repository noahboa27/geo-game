package com.example.geogame.core.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class Country(
    @PrimaryKey val id: Int,
    val name: String,
    val flag: String
)