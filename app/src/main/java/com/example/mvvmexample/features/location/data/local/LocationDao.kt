package com.example.mvvmexample.features.location.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmexample.features.location.data.local.model.LocationCached

@Dao
interface LocationDao {
    @Query("SELECT * from locationcached")
    suspend fun getLocations(): List<LocationCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg episode: LocationCached)
}