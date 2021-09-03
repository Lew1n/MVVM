package com.example.mvvmexample.core.api.model

import com.example.mvvmexample.features.characters.domain.model.CharacterLocation
import com.google.gson.annotations.SerializedName

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}