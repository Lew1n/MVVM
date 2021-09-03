package com.example.mvvmexample.features.location.domain

import com.example.mvvmexample.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}