package com.example.tmdbapplication.data.repository.movies.datasource.local

import com.example.tmdbapplication.data.model.movie.db.DBMovie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<DBMovie>
    suspend fun saveMoviesToDB(movies: List<DBMovie>)
    suspend fun getMoviesByVoteAverageAscending(): List<DBMovie>
    suspend fun getMoviesByVoteAverageDescending(): List<DBMovie>
    suspend fun clearAllMovies()
}