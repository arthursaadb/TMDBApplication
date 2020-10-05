package com.example.tmdbapplication.data.api

import com.example.tmdbapplication.data.model.movie.response.PopularMovieResponse
import com.example.tmdbapplication.data.model.people.response.PopularPeopleResponse
import com.example.tmdbapplication.data.model.tvshow.response.PopularTvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface TMDBService {
    @GET("/movie/popular")
    suspend fun getPopularMovies(): Response<PopularMovieResponse>

    @GET("/person/popular")
    suspend fun getPopularPeople(): Response<PopularPeopleResponse>

    @GET("/tv/popular")
    suspend fun getPopularTvShow(): Response<PopularTvShowResponse>
}