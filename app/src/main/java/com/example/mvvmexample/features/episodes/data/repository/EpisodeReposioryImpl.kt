package com.example.mvvmexample.features.episodes.data.repository

import com.example.mvvmexample.core.api.RickAndMortyApi
import com.example.mvvmexample.core.exception.ErrorWrapper
import com.example.mvvmexample.core.exception.callOrThrow
import com.example.mvvmexample.core.network.NetworkStateProvider
import com.example.mvvmexample.features.episodes.data.local.EpisodeDao
import com.example.mvvmexample.features.episodes.data.local.model.EpisodeCached
import com.example.mvvmexample.features.episodes.domain.EpisodeRepository
import com.example.mvvmexample.features.episodes.domain.model.Episode


class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getEpisodesFromRemote() }
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisodes()
            .results
            .map { it.toEpisode() }
    }

    private suspend fun saveEpisodesToLocal(episode: List<Episode>) {
        episode.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes()
            .map { it.toEpisode() }
    }
}
