package com.example.mvvmexample.features.location.domain

import com.example.mvvmexample.core.base.UseCase
import com.example.mvvmexample.features.location.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}