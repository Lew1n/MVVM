package com.example.mvvmexample.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmexample.features.characters.data.local.CharacterDao
import com.example.mvvmexample.features.characters.data.local.model.CharacterCached
import com.example.mvvmexample.features.episodes.data.local.EpisodeDao
import com.example.mvvmexample.features.episodes.data.local.model.EpisodeCached
import com.example.mvvmexample.features.location.data.local.LocationDao
import com.example.mvvmexample.features.location.data.local.model.LocationCached

@Database(
    entities = [
        EpisodeCached::class,
        CharacterCached::class,
        LocationCached::class
    ], version = 1
)

@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao

    abstract fun characterDao(): CharacterDao

    abstract fun locationDao(): LocationDao

}