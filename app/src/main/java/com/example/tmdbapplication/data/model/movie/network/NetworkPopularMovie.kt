package com.example.tmdbapplication.data.model.movie.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkPopularMovie(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<NetworkMovie>
)