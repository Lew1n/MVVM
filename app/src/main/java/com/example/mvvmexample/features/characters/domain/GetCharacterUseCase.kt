package com.example.mvvmexample.features.characters.domain

import com.example.mvvmexample.core.base.UseCase
import com.example.mvvmexample.features.characters.domain.model.Character

class GetCharacterUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}