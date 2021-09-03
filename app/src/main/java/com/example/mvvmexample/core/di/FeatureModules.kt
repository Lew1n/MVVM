package com.example.mvvmexample.core.di

import com.example.mvvmexample.features.characters.di.characterModule
import com.example.mvvmexample.features.episodes.di.episodeModule
import com.example.mvvmexample.features.location.di.locationModule
import org.koin.core.module.Module


var featureModules = listOf<Module>(
    episodeModule,
    locationModule,
    characterModule
)