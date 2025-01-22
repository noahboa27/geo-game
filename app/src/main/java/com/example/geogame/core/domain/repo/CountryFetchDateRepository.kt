package com.example.geogame.core.domain.repo

import com.example.geogame.core.data.cache.model.CountryFetchDate

interface CountryFetchDateRepository {
    suspend fun insert(time: CountryFetchDate)
    suspend fun getLastFetchTime(): Long
}