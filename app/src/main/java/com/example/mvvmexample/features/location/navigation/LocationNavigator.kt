package com.example.mvvmexample.features.location.navigation

import com.example.mvvmexample.features.location.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}