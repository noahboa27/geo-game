package com.example.geogame.core.data.repository

import com.example.geogame.core.data.cache.dao.CountriesDao
import com.example.geogame.core.data.cache.model.LocalCountry
import com.example.geogame.core.domain.repo.CountryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryRepositoryImpl(
    private val countriesDao: CountriesDao,
    private val scope: CoroutineScope,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): CountryRepository {

    override suspend fun insertAllCountries(vararg countries: LocalCountry) =
        scope.launch {
            countriesDao.insertAll(*countries)
        }.join()

    override suspend fun getCountryBy(name: String): LocalCountry =
        withContext(dispatcher) {
            countriesDao.getCountryBy(name)
        }

    override suspend fun getRandomCountries(numberOfCountries: Int): List<LocalCountry> =
        withContext(dispatcher) {
            countriesDao.getRandomCountries(numberOfCountries)
        }

}