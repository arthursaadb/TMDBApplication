package com.example.tmdbapplication.domain.movies.repository

import com.example.tmdbapplication.data.model.movie.MovieModel

interface MovieRepository {
    suspend fun getMovies(): List<MovieModel>?
    suspend fun updateMovies(): List<MovieModel>?
}