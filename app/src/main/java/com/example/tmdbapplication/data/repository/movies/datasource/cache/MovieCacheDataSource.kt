package com.example.tmdbapplication.data.repository.movies.datasource.cache

import com.example.tmdbapplication.data.model.movie.MovieModel

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<MovieModel>
    suspend fun saveMoviesToCache(movies: List<MovieModel>)
}