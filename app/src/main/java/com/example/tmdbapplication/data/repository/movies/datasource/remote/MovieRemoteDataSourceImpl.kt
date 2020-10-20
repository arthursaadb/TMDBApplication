package com.example.tmdbapplication.data.repository.movies.datasource.remote

import com.example.tmdbapplication.data.api.TMDBService
import com.example.tmdbapplication.data.model.movie.network.NetworkPopularMovie
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val api: TMDBService) :
    MovieRemoteDataSource {
    override suspend fun getMoviesFromNetwork(): Response<NetworkPopularMovie> =
        api.getPopularMovies()
}