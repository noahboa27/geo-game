package com.example.geogame.core.data.network.api

import com.example.geogame.core.data.network.model.RemoteCountry
import retrofit2.http.GET

interface RestCountriesApi {
    @GET("all?fields=cca2,cca3,area,borders,capital,car,coatOfArms,currencies,flag,flags,landlocked,languages,maps,name,population,region,subregion,tld,unMember")
    suspend fun getAllCountries(): List<RemoteCountry>
}