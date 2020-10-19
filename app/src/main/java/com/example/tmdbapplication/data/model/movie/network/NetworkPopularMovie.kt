package com.example.tmdbapplication.data.model.movie.network

import com.squareup.moshi.Json

data class NetworkPopularMovie(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<NetworkMovie>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)