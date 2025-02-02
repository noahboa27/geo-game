package com.example.geogame.core.data.mapper

import com.example.geogame.core.data.cache.model.LocalCountry
import com.example.geogame.core.data.network.model.RemoteCountry
import com.example.geogame.flag_game.domain.data.FlagGameCountry

object CountryMapper {
    fun toLocal(remoteCountry: RemoteCountry) = LocalCountry(
        area = remoteCountry.area,
        borders = remoteCountry.borders,
        capital = remoteCountry.capital,
        car = remoteCountry.car,
        cca2 = remoteCountry.cca2,
        cca3 = remoteCountry.cca3,
        coatOfArms = remoteCountry.coatOfArms,
        continents = remoteCountry.continents,
        currencies = remoteCountry.currencies,
        flag = remoteCountry.flag,
        flags = remoteCountry.flags,
        independent = remoteCountry.independent,
        landlocked = remoteCountry.landlocked,
        languages = remoteCountry.languages,
        maps = remoteCountry.maps,
        name = remoteCountry.name,
        population = remoteCountry.population,
        region = remoteCountry.region,
        subregion = remoteCountry.subregion,
        tld = remoteCountry.tld,
        unMember = remoteCountry.unMember
    )

    fun toFlagGameCountry(localCountry: LocalCountry) = FlagGameCountry(
        flagUrl = localCountry.flags.svg,
        name = localCountry.name.common,
        isAnswer = false
    )

    // just some other ideas
    // fun toGlobeGameCountry
    // fun toTriviaGameCountry
}