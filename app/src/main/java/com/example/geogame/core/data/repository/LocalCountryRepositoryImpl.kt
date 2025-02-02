package com.example.geogame.core.data.repository

import com.example.geogame.core.data.cache.dao.CountriesDao
import com.example.geogame.core.data.cache.model.LocalCountry
import com.example.geogame.core.domain.repo.LocalCountryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalCountryRepositoryImpl(
    private val countriesDao: CountriesDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): LocalCountryRepository {

    override suspend fun insertAll(countries: List<LocalCountry>) =
        withContext(dispatcher) {
            countriesDao.insertAll(*countries.toTypedArray())
        }

    override suspend fun getCountryBy(name: String): LocalCountry =
        withContext(dispatcher) {
            countriesDao.getCountryBy(name)
        }

    override suspend fun getRandomCountries(numberOfCountries: Int): List<LocalCountry> =
        withContext(dispatcher) {
            countriesDao.getRandomCountries(numberOfCountries)
        }

}