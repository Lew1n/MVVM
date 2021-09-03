package com.example.mvvmexample.features.location.data.repository

import com.example.mvvmexample.core.api.RickAndMortyApi
import com.example.mvvmexample.core.exception.ErrorWrapper
import com.example.mvvmexample.core.exception.callOrThrow
import com.example.mvvmexample.core.network.NetworkStateProvider
import com.example.mvvmexample.features.location.data.local.LocationDao
import com.example.mvvmexample.features.location.data.local.model.LocationCached
import com.example.mvvmexample.features.location.domain.LocationRepository
import com.example.mvvmexample.features.location.domain.model.Location


class LocationRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getLocationsFromRemote() }
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations()
            .results
            .map { it.toLocation() }
    }

    private suspend fun saveLocationsToLocal(episode: List<Location>) {
        episode.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return locationDao.getLocations()
            .map { it.toLocation() }
    }
}