package com.example.mvvmexample.features.characters.all.presentation.model

import android.os.Parcelable
import com.example.mvvmexample.features.characters.domain.model.Character
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDisplayable,
    val characterLocation: CharacterLocationDisplayable,
    val image: String,
    val episodes: List<String>,
    val url: String
) : Parcelable {

    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = OriginDisplayable(
            character.origin
        ),
        characterLocation = CharacterLocationDisplayable(
            character.characterLocation
        ),
        image = character.image,
        episodes = character.episodes,
        url = character.url
    )

    companion object
}
