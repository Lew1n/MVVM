package com.example.mvvmexample.features.characters.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val characterLocation: CharacterLocation,
    val image: String,
    val episodes: List<String>,
    val url: String
) {
    companion object
}