package com.example.tmdbapplication.data.model.movie

data class MovieModel(
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String
) {
    val movieUrl
        get() = "https://image.tmdb.org/t/p/w500/$posterPath"
}