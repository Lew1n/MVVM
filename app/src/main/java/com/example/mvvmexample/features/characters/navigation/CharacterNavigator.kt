package com.example.mvvmexample.features.characters.navigation

import com.example.mvvmexample.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}