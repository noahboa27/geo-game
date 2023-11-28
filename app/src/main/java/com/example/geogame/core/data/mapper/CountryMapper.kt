package com.example.geogame.core.data.mapper

import com.example.geogame.core.data.cache.model.LocalCountry
import com.example.geogame.core.data.network.model.CountryApiModel
import com.example.geogame.core.domain.model.FlagGameCountry

object CountryMapper {
    fun toLocal(countryApiModel: CountryApiModel) = LocalCountry(
        altSpellings = countryApiModel.altSpellings,
        area = countryApiModel.area,
        borders = countryApiModel.borders,
        capital = countryApiModel.capital,
        capitalInfo = countryApiModel.capitalInfo,
        car = countryApiModel.car,
        cca2 = countryApiModel.cca2,
        cca3 = countryApiModel.cca3,
        ccn3 = countryApiModel.ccn3,
        cioc = countryApiModel.cioc,
        coatOfArms = countryApiModel.coatOfArms,
        continents = countryApiModel.continents,
        currencies = countryApiModel.currencies,
        demonyms = countryApiModel.demonyms,
        fifa = countryApiModel.fifa,
        flag = countryApiModel.flag,
        flags = countryApiModel.flags,
        gini = countryApiModel.gini,
        idd = countryApiModel.idd,
        independent = countryApiModel.independent,
        landlocked = countryApiModel.landlocked,
        languages = countryApiModel.languages,
        latlng = countryApiModel.latlng,
        maps = countryApiModel.maps,
        name = countryApiModel.name,
        population = countryApiModel.population,
        postalCode = countryApiModel.postalCode,
        region = countryApiModel.region,
        startOfWeek = countryApiModel.startOfWeek,
        status = countryApiModel.status,
        subregion = countryApiModel.subregion,
        timezones = countryApiModel.timezones,
        tld = countryApiModel.tld,
        translations = countryApiModel.translations,
        unMember = countryApiModel.unMember
    )

    fun toFlagGameCountry(localCountry: LocalCountry) = FlagGameCountry(
        flag = localCountry.flag,
        name = localCountry.name
    )

    // fun toGlobeGameCountry
    // fun toTriviaGameCountry
    // just some other ideas
}