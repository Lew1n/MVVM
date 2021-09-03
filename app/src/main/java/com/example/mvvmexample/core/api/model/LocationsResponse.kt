package com.example.mvvmexample.core.api.model

import com.google.gson.annotations.SerializedName

data class LocationsResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
) {
    companion object
}