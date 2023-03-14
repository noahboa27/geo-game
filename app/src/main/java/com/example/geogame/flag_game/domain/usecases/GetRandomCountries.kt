package com.example.geogame.flag_game.domain.usecases

import com.example.geogame.core.data.repository.CountryRepository
import com.example.geogame.core.domain.model.Country

class GetRandomCountries(
    private val countryRepository: CountryRepository
) {
    suspend operator fun invoke(
        numOfCountries: Int
    ): List<Country> =
        countryRepository.getRandomCountries(numOfCountries).map {
            it.toDomain()
        }
}