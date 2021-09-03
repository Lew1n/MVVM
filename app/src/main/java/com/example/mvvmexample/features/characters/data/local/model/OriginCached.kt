package com.example.mvvmexample.features.characters.data.local.model

import com.example.mvvmexample.features.characters.domain.model.Origin

data class OriginCached(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        origin.name,
        origin.url
    )

    companion object

    fun toOrigin() = Origin(
        name = name,
        url = url
    )
}