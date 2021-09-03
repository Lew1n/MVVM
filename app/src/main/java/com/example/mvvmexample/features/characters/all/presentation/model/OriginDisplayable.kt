package com.example.mvvmexample.features.characters.all.presentation.model

import android.os.Parcelable
import com.example.mvvmexample.features.characters.domain.model.Origin
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OriginDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )

    companion object
}