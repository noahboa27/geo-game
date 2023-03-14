package com.example.geogame.core.data.network.api

import com.example.geogame.core.data.network.model.ApiCountry
import retrofit2.http.GET

interface RestCountriesApi {
    @GET("all")
    suspend fun getAllCountries(): List<ApiCountry>
}