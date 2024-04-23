package com.example.geogame.core.data.network.api

import com.example.geogame.core.data.network.model.RemoteCountry
import retrofit2.http.GET

interface RestCountriesApi {
    @GET("all")
    suspend fun getAllCountries(): List<RemoteCountry>
}