package com.example.mvvmexample.features.episodes.navigation

import com.example.mvvmexample.R
import com.example.mvvmexample.core.navigation.FragmentNavigator
import com.example.mvvmexample.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.mvvmexample.features.episodes.details.EpisodeDetailsFragment

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}