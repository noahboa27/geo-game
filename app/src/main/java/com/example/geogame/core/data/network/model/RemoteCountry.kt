package com.example.geogame.core.data.network.model

import com.example.geogame.core.domain.model.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteCountry(
    @Json(name = "alt_spellings") val altSpellings: List<String> = listOf(),
    @Json(name = "area") val area: Double = 0.0,
    @Json(name = "borders") val borders: List<String> = listOf(),
    @Json(name = "capital") val capital: List<String> = listOf(),
    @Json(name = "capital_info") val capitalInfo: CapitalInfo = CapitalInfo(),
    @Json(name = "car") val car: Car = Car(),
    @Json(name = "cca2") val cca2: String = "",
    @Json(name = "cca3") val cca3: String = "",
    @Json(name = "ccn3") val ccn3: String = "",
    @Json(name = "cioc") val cioc: String = "",
    @Json(name = "coat_of_arms") val coatOfArms: CoatOfArms = CoatOfArms(),
    @Json(name = "continents") val continents: List<String> = listOf(),
    @Json(name = "currencies") val currencies: Currencies = Currencies(),
    @Json(name = "demonyms") val demonyms: Demonyms = Demonyms(),
    @Json(name = "fifa") val fifa: String = "",
    @Json(name = "flag") val flag: String = "",
    @Json(name = "flags") val flags: Flags = Flags(),
    @Json(name = "gini") val gini: Gini = Gini(),
    @Json(name = "idd") val idd: Idd = Idd(),
    @Json(name = "independent") val independent: Boolean = false,
    @Json(name = "land_locked") val landlocked: Boolean = false,
    @Json(name = "languages") val languages: Languages = Languages(),
    @Json(name = "lat_lng") val latlng: List<Double> = listOf(),
    @Json(name = "maps") val maps: Maps = Maps(),
    @Json(name = "name") val name: Name = Name(),
    @Json(name = "population") val population: Int = 0,
    @Json(name = "postalCode") val postalCode: PostalCode = PostalCode(),
    @Json(name = "region") val region: String = "",
    @Json(name = "start_of_week") val startOfWeek: String = "",
    @Json(name = "status") val status: String = "",
    @Json(name = "subregion") val subregion: String = "",
    @Json(name = "timezones") val timezones: List<String> = listOf(),
    @Json(name = "tld") val tld: List<String> = listOf(),
    @Json(name = "translations") val translations: Translations = Translations(),
    @Json(name = "un_member") val unMember: Boolean = false
)