package com.example.geogame.flag_game.domain.usecases

import com.example.geogame.core.domain.repo.CountryRepository
import com.example.geogame.core.domain.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRandomCountries(
    private val countryRepository: CountryRepository
) {
    suspend operator fun invoke(
        numOfCountries: Int
    ): List<Country> =
        withContext(Dispatchers.IO) {
            countryRepository.getRandomCountries(numOfCountries).map {
                it.toDomain()
            }
        }
}