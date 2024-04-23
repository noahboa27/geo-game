package com.example.geogame.core.data.mapper

import com.example.geogame.core.data.cache.model.LocalCountry
import com.example.geogame.core.data.network.model.RemoteCountry
import com.example.geogame.core.domain.model.FlagGameCountry

object CountryMapper {
    fun toLocal(remoteCountry: RemoteCountry) = LocalCountry(
        altSpellings = remoteCountry.altSpellings,
        area = remoteCountry.area,
        borders = remoteCountry.borders,
        capital = remoteCountry.capital,
        capitalInfo = remoteCountry.capitalInfo,
        car = remoteCountry.car,
        cca2 = remoteCountry.cca2,
        cca3 = remoteCountry.cca3,
        ccn3 = remoteCountry.ccn3,
        cioc = remoteCountry.cioc,
        coatOfArms = remoteCountry.coatOfArms,
        continents = remoteCountry.continents,
        currencies = remoteCountry.currencies,
        demonyms = remoteCountry.demonyms,
        fifa = remoteCountry.fifa,
        flag = remoteCountry.flag,
        flags = remoteCountry.flags,
        gini = remoteCountry.gini,
        idd = remoteCountry.idd,
        independent = remoteCountry.independent,
        landlocked = remoteCountry.landlocked,
        languages = remoteCountry.languages,
        latlng = remoteCountry.latlng,
        maps = remoteCountry.maps,
        name = remoteCountry.name,
        population = remoteCountry.population,
        postalCode = remoteCountry.postalCode,
        region = remoteCountry.region,
        startOfWeek = remoteCountry.startOfWeek,
        status = remoteCountry.status,
        subregion = remoteCountry.subregion,
        timezones = remoteCountry.timezones,
        tld = remoteCountry.tld,
        translations = remoteCountry.translations,
        unMember = remoteCountry.unMember
    )

    fun toFlagGameCountry(localCountry: LocalCountry) = FlagGameCountry(
        flag = localCountry.flag,
        name = localCountry.name
    )

    // fun toGlobeGameCountry
    // fun toTriviaGameCountry
    // just some other ideas
}