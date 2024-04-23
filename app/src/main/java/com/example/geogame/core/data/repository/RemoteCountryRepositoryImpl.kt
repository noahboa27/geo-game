package com.example.geogame.core.data.repository

import com.example.geogame.core.data.network.api.RestCountriesApi
import com.example.geogame.core.data.network.model.RemoteCountry
import com.example.geogame.core.domain.repo.RemoteCountryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteCountryRepositoryImpl(
    private val restCountriesApi: RestCountriesApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): RemoteCountryRepository {
    override suspend fun getRestCountries(): List<RemoteCountry> =
        withContext(dispatcher) {
            restCountriesApi.getAllCountries()
        }
}