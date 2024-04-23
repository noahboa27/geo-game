package com.example.geogame.core.domain.repo

import com.example.geogame.core.data.network.model.RemoteCountry

interface RemoteCountryRepository {
    suspend fun getRestCountries(): List<RemoteCountry>
}