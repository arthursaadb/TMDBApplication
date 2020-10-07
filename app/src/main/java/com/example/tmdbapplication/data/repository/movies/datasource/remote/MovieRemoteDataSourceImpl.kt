package com.example.tmdbapplication.data.repository.movies.datasource.remote

import com.example.tmdbapplication.data.api.TMDBService
import com.example.tmdbapplication.data.model.movie.response.PopularMovieResponse
import com.example.tmdbapplication.data.repository.movies.datasource.remote.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val api: TMDBService) :
    MovieRemoteDataSource {
    override suspend fun getMoviesFromNetwork(): Response<PopularMovieResponse> =
        api.getPopularMovies()
}