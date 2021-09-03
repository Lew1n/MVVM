package com.example.mvvmexample.core.api

import com.example.mvvmexample.core.api.model.CharactersResponse
import com.example.mvvmexample.core.api.model.EpisodesResponse
import com.example.mvvmexample.core.api.model.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse
}