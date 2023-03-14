package com.example.geogame.core.data.repository

import com.example.geogame.core.data.cache.model.LocalCountry

interface CountryRepository {
    suspend fun getCountryBy(name: String): LocalCountry
    suspend fun getRandomCountries(numberOfCountries: Int): List<LocalCountry>
}