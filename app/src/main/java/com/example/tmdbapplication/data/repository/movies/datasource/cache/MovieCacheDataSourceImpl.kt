package com.example.tmdbapplication.data.repository.movies.datasource.cache

import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.data.repository.movies.datasource.cache.MovieCacheDataSource
import javax.inject.Inject

class MovieCacheDataSourceImpl @Inject constructor() : MovieCacheDataSource {
    private var movieList = ArrayList<MovieModel>()
    override suspend fun getMoviesFromCache(): List<MovieModel> = movieList

    override suspend fun saveMoviesToCache(movies: List<MovieModel>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}