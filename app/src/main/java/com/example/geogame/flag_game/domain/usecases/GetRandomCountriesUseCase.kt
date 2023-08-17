package com.example.geogame.flag_game.domain.usecases

import com.example.geogame.core.data.mapper.CountryMapper
import com.example.geogame.core.domain.repo.CountryRepository
import com.example.geogame.core.domain.model.Country
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRandomCountriesUseCase(
    private val countryRepository: CountryRepository,
    private val coroutineContext: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(
        numOfCountries: Int
    ): List<Country> =
        withContext(coroutineContext) {
            countryRepository.getRandomCountries(numOfCountries).map {
                CountryMapper.toDomain(it)
            }
        }
}