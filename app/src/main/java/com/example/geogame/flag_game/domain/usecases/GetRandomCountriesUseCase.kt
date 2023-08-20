package com.example.geogame.flag_game.domain.usecases

import com.example.geogame.core.data.mapper.CountryMapper
import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.core.domain.repo.CountryRepository

class GetRandomCountriesUseCase(
    private val countryRepository: CountryRepository
) {
    suspend operator fun invoke(
        numOfCountries: Int
    ): Result<List<FlagGameCountry>> =
        try {
            Result.success(countryRepository.getRandomCountries(numOfCountries).map {
                CountryMapper.toFlagGameCountry(it)
            })
        } catch (t: Throwable) {
            Result.failure(t)
        }

}