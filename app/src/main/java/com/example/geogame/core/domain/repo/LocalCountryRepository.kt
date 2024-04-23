package com.example.geogame.core.domain.repo

import com.example.geogame.core.data.cache.model.LocalCountry

interface LocalCountryRepository {
    suspend fun insertCountry(country: LocalCountry)
    suspend fun getCountryBy(name: String): LocalCountry
    suspend fun getRandomCountries(numberOfCountries: Int): List<LocalCountry>
}