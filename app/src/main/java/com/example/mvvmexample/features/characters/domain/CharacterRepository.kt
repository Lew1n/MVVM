package com.example.mvvmexample.features.characters.domain

import com.example.mvvmexample.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}