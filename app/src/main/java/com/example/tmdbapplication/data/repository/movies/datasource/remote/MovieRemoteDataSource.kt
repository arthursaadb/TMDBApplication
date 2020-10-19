package com.example.tmdbapplication.data.repository.movies.datasource.remote

import com.example.tmdbapplication.data.model.movie.network.NetworkPopularMovie
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMoviesFromNetwork(): Response<NetworkPopularMovie>
}