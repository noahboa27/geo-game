package com.example.geogame.flag_game.domain.useCase

import com.example.geogame.core.data.mapper.CountryMapper
import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.core.domain.repo.LocalCountryRepository

class GetRandomCountriesUseCase(
    private val localCountryRepository: LocalCountryRepository
) {
    suspend operator fun invoke(
        numOfCountries: Int
    ): Result<List<FlagGameCountry>> =
        try {
            Result.success(localCountryRepository.getRandomCountries(numOfCountries).map {
                CountryMapper.toFlagGameCountry(it)
            })
        } catch (t: Throwable) {
            Result.failure(t)
        }

}