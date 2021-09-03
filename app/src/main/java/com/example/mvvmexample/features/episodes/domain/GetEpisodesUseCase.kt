package com.example.mvvmexample.features.episodes.domain

import com.example.mvvmexample.core.base.UseCase
import com.example.mvvmexample.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}
