package com.example.mvvmexample.features.characters.data.local.model

import com.example.mvvmexample.features.characters.domain.model.CharacterLocation

data class CharacterLocationCached(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )

    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}