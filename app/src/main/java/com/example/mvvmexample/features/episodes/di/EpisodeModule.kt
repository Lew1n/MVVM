package com.example.mvvmexample.features.episodes.di

import com.example.mvvmexample.features.episodes.all.presentation.EpisodeAdapter
import com.example.mvvmexample.features.episodes.all.presentation.EpisodesFragment
import com.example.mvvmexample.features.episodes.all.presentation.EpisodesViewModel
import com.example.mvvmexample.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.mvvmexample.features.episodes.details.EpisodeDetailsFragment
import com.example.mvvmexample.features.episodes.details.EpisodeViewModel
import com.example.mvvmexample.features.episodes.domain.EpisodeRepository
import com.example.mvvmexample.features.episodes.domain.GetEpisodesUseCase
import com.example.mvvmexample.features.episodes.navigation.EpisodeNavigator
import com.example.mvvmexample.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


var episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodesViewModel(get(), get(), get()) }
    viewModel { EpisodeViewModel() }
    factory { EpisodesFragment() }
    factory { EpisodeDetailsFragment() }
    factory { EpisodeAdapter() }

    //navigation
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
}