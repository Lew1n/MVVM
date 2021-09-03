package com.example.mvvmexample.features.episodes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmexample.features.episodes.domain.model.Episode


@Entity
data class EpisodeCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) {

    constructor(episode: Episode) : this(
        episode.id,
        episode.name,
        episode.airDate,
        episode.code,
        episode.characters,
        episode.url
    )

    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = characters,
        url = url
    )
}