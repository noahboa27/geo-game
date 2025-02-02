package com.example.geogame.core.data.network.model

import com.example.geogame.core.domain.model.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteCountry(
    @Json(name = "area") val area: Double = 0.0,
    @Json(name = "borders") val borders: List<String> = listOf(),
    @Json(name = "capital") val capital: List<String> = listOf(),
    @Json(name = "car") val car: Car = Car(),
    @Json(name = "cca2") val cca2: String = "",
    @Json(name = "cca3") val cca3: String = "",
    @Json(name = "coat_of_arms") val coatOfArms: CoatOfArms = CoatOfArms(),
    @Json(name = "continents") val continents: List<String> = listOf(),
    @Json(name = "currencies") val currencies: Currencies = Currencies(),
    @Json(name = "flag") val flag: String = "",
    @Json(name = "flags") val flags: Flags = Flags(),
    @Json(name = "independent") val independent: Boolean = false,
    @Json(name = "land_locked") val landlocked: Boolean = false,
    @Json(name = "languages") val languages: Languages = Languages(),
    @Json(name = "maps") val maps: Maps = Maps(),
    @Json(name = "name") val name: Name = Name(),
    @Json(name = "population") val population: Int = 0,
    @Json(name = "region") val region: String = "",
    @Json(name = "subregion") val subregion: String = "",
    @Json(name = "tld") val tld: List<String> = listOf(),
    @Json(name = "un_member") val unMember: Boolean = false
)