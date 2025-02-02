package com.example.geogame.core.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.geogame.core.domain.model.*

@Entity(tableName = "countries")
data class LocalCountry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val car: Car,
    val cca2: String,
    val cca3: String,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val currencies: Currencies,
    val flag: String,
    val flags: Flags,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: Languages,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val region: String,
    val subregion: String,
    val tld: List<String>,
    val unMember: Boolean
)