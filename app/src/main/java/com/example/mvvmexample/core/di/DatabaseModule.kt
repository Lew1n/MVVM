package com.example.mvvmexample.core.di

import androidx.room.Room
import com.example.mvvmexample.core.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database").build()
    }

    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().characterDao() }
    single { get<AppDatabase>().locationDao() }
}