package com.example.tmdbapplication.data.repository.movies.datasource.local

import com.example.tmdbapplication.data.db.MovieDao
import com.example.tmdbapplication.data.model.movie.db.DBMovie
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(private val movieDao: MovieDao) :
    MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<DBMovie> =
        movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<DBMovie>) {
        movieDao.saveMovies(movies)
    }

    override suspend fun getMoviesByVoteAverageDescending(): List<DBMovie> =
        movieDao.loadMoviesByVoteAverageDescending()

    override suspend fun getMoviesByVoteAverageAscending(): List<DBMovie> =
        movieDao.loadMoviesByVoteAverageAscending()

    override suspend fun clearAllMovies() {
        movieDao.deleteAllMovies()
    }
}