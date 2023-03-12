package com.example.geogame.core.repository

import com.example.geogame.core.data.cache.model.Country

interface CountryRepository {
    suspend fun getCountryBy(name: String): Country
    suspend fun getRandomCountries(numberOfCountries: Int): List<Country>
}