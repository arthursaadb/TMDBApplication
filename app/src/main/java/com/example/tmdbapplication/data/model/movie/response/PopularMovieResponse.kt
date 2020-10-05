package com.example.tmdbapplication.data.model.movie.response

import com.example.tmdbapplication.data.model.movie.response.MovieResponse
import com.squareup.moshi.Json

data class PopularMovieResponse(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<MovieResponse>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)