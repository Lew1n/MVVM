package com.example.mvvmexample.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featureModules
    .plus(networkModule)
    .plus(databaseModule)
    .plus(appModule)
