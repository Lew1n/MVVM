package com.example.mvvmexample.features.characters.navigation

import com.example.mvvmexample.R
import com.example.mvvmexample.core.navigation.FragmentNavigator
import com.example.mvvmexample.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmexample.features.characters.details.CharacterDetailsFragment

class CharacterNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {

    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_characters_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}