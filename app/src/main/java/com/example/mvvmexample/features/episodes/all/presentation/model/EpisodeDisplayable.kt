package com.example.mvvmexample.features.episodes.all.presentation.model

import android.os.Parcelable
import com.example.mvvmexample.features.episodes.domain.model.Episode
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) : Parcelable {

    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )

    @IgnoredOnParcel
    val fullName = "$code: $name"

    companion object
}