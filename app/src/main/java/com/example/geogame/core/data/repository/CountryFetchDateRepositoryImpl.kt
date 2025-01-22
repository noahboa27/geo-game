package com.example.geogame.core.data.repository

import com.example.geogame.core.data.cache.dao.CountryFetchDateDao
import com.example.geogame.core.data.cache.model.CountryFetchDate
import com.example.geogame.core.domain.repo.CountryFetchDateRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryFetchDateRepositoryImpl(
    private val countryFetchDateDao: CountryFetchDateDao,
    private val scope: CoroutineScope,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): CountryFetchDateRepository {
    override suspend fun insert(time: CountryFetchDate) =
        scope.launch {
            countryFetchDateDao.insert(time)
        }.join()

    override suspend fun getLastFetchTime(): Long =
        withContext(dispatcher) {
            countryFetchDateDao.getLastFetchTime()
        }
}