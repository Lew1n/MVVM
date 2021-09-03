package com.example.mvvmexample.features.characters.data.repository

import com.example.mvvmexample.core.api.RickAndMortyApi
import com.example.mvvmexample.core.exception.ErrorWrapper
import com.example.mvvmexample.core.exception.callOrThrow
import com.example.mvvmexample.core.network.NetworkStateProvider
import com.example.mvvmexample.features.characters.data.local.CharacterDao
import com.example.mvvmexample.features.characters.data.local.model.CharacterCached
import com.example.mvvmexample.features.characters.domain.CharacterRepository
import com.example.mvvmexample.features.characters.domain.model.Character


class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getCharactersFromRemote() }
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(character: List<Character>) {
        character.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }
    }

}