package com.example.geogame.core.data.repository.impl

import com.example.geogame.core.data.cache.dao.CountriesDao
import com.example.geogame.core.data.cache.model.LocalCountry
import com.example.geogame.core.data.repository.CountryRepository

class CountryRepositoryImpl(
    private val countriesDao: CountriesDao
): CountryRepository {

    override suspend fun getCountryBy(name: String): LocalCountry =
        countriesDao.getCountryBy(name)

    override suspend fun getRandomCountries(numberOfCountries: Int): List<LocalCountry> =
        countriesDao.getRandomCountries(numberOfCountries)

}