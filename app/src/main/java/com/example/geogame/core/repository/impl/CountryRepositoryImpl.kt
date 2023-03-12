package com.example.geogame.core.repository.impl

import com.example.geogame.core.data.cache.dao.CountriesDao
import com.example.geogame.core.data.cache.model.Country
import com.example.geogame.core.repository.CountryRepository

class CountryRepositoryImpl(
    private val countriesDao: CountriesDao
): CountryRepository {

    override suspend fun getCountryBy(name: String): Country =
        countriesDao.getCountryBy(name)

    override suspend fun getRandomCountries(numberOfCountries: Int): List<Country> =
        countriesDao.getRandomCountries(numberOfCountries)

}