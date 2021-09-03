package com.example.mvvmexample.features.location.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmexample.features.location.domain.model.Location

@Entity
data class LocationCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) {
    constructor(location: Location) : this(
        location.id,
        location.name,
        location.type,
        location.dimension,
        location.residents,
        location.url
    )

    companion object

    fun toLocation() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents,
        url = url
    )
}