package com.example.mvvmexample.features.characters.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.core.base.BaseViewModel
import com.example.mvvmexample.core.exception.ErrorMapper
import com.example.mvvmexample.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmexample.features.characters.domain.GetCharacterUseCase
import com.example.mvvmexample.features.characters.domain.model.Character
import com.example.mvvmexample.features.characters.navigation.CharacterNavigator

class CharactersViewModel(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val characterNavigator: CharacterNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharacterUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onCharacterClick(character: CharacterDisplayable) {
        characterNavigator.openCharacterDetailsScreen(character)
    }
}