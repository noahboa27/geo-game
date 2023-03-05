package com.example.countrygame.core.repository

import com.example.countrygame.core.data.dao.CountriesDao
import com.example.countrygame.core.data.model.Country

class CountryRepository(private val countriesDao: CountriesDao) {

    suspend fun getCountryBy(name: String): Country =
        countriesDao.getCountryBy(name)

    suspend fun getRandomCountries(numberOfCountries: Int): List<Country> =
        countriesDao.getRandomCountries(numberOfCountries)

}