package com.example.mvvmexample.core.api.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}