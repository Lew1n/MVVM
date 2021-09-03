package com.example.mvvmexample.features.episodes.details

import com.example.mvvmexample.BR
import com.example.mvvmexample.R
import com.example.mvvmexample.core.base.BaseFragment
import com.example.mvvmexample.databinding.FragmentEpisodeDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeDetailsFragment :
    BaseFragment<EpisodeViewModel, FragmentEpisodeDetailsBinding>(BR.viewModel,
        R.layout.fragment_episode_details) {

    override val viewModel: EpisodeViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}