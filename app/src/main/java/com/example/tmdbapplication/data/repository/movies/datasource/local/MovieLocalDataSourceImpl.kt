package com.example.tmdbapplication.data.repository.movies.datasource.local

import com.example.tmdbapplication.data.db.MovieDao
import com.example.tmdbapplication.data.model.movie.db.DBMovie
import com.example.tmdbapplication.data.repository.movies.datasource.local.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(private val movieDao: MovieDao) :
    MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<DBMovie> =
        movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<DBMovie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAllMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}