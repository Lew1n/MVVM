package com.example.mvvmexample.features.episodes.domain

import com.example.mvvmexample.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}