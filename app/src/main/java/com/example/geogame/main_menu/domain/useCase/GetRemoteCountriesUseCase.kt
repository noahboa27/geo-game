package com.example.geogame.main_menu.domain.useCase

import com.example.geogame.core.data.network.model.RemoteCountry
import com.example.geogame.core.domain.repo.RemoteCountryRepository

class GetRemoteCountriesUseCase(
    private val remoteCountryRepository: RemoteCountryRepository
) {
    suspend operator fun invoke(): Result<List<RemoteCountry>> =
        try {
            Result.success(remoteCountryRepository.getRestCountries())
        } catch (t: Throwable) {
            Result.failure(t)
        }
}