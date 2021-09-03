package com.example.mvvmexample.mock

import com.example.mvvmexample.core.api.model.*
import com.example.mvvmexample.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmexample.features.characters.all.presentation.model.CharacterLocationDisplayable
import com.example.mvvmexample.features.characters.all.presentation.model.OriginDisplayable
import com.example.mvvmexample.features.characters.data.local.model.CharacterCached
import com.example.mvvmexample.features.characters.data.local.model.CharacterLocationCached
import com.example.mvvmexample.features.characters.data.local.model.OriginCached
import com.example.mvvmexample.features.characters.domain.model.Character
import com.example.mvvmexample.features.characters.domain.model.CharacterLocation
import com.example.mvvmexample.features.characters.domain.model.Origin
import com.example.mvvmexample.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.mvvmexample.features.episodes.data.local.model.EpisodeCached
import com.example.mvvmexample.features.episodes.domain.model.Episode
import com.example.mvvmexample.features.location.all.presentation.model.LocationDisplayable
import com.example.mvvmexample.features.location.data.local.model.LocationCached
import com.example.mvvmexample.features.location.domain.model.Location
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 2,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 2,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    id = 2,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 2,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character typ",
    gender = "character gender",
    origin = OriginRemote.mock(),
    characterLocation = CharacterLocationRemote.mock(),
    image = "character image",
    episodes = emptyList(),
    url = "character url",
    created = "example data"
)

@TestOnly
fun OriginRemote.Companion.mock() = OriginRemote(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 2,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character typ",
    gender = "character gender",
    origin = OriginCached.mock(),
    characterLocation = CharacterLocationCached.mock(),
    image = "character image",
    episodes = emptyList(),
    url = "character url"
)

@TestOnly
fun CharacterDisplayable.Companion.mock() = CharacterDisplayable(
    id = 2,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character typ",
    gender = "character gender",
    origin = OriginDisplayable.mock(),
    characterLocation = CharacterLocationDisplayable.mock(),
    image = "character image",
    episodes = emptyList(),
    url = "character url"
)

@TestOnly
fun OriginCached.Companion.mock() = OriginCached(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun OriginDisplayable.Companion.mock() = OriginDisplayable(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharacterLocationDisplayable.Companion.mock() = CharacterLocationDisplayable(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url",
    created = "example data"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun LocationDisplayable.Companion.mock() = LocationDisplayable(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 2,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    id = 2,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character typ",
    gender = "character gender",
    origin = Origin.mock(),
    characterLocation = CharacterLocation.mock(),
    image = "character image",
    episodes = emptyList(),
    url = "character url"
)

@TestOnly
fun Origin.Companion.mock() = Origin(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharacterLocation.Companion.mock() = CharacterLocation(
    name = "origin name",
    url = "origin url"
)

