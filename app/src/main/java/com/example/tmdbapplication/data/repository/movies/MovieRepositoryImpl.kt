package com.example.tmdbapplication.data.repository.movies

import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.data.model.movie.db.DBMovie
import com.example.tmdbapplication.data.repository.movies.datasource.cache.MovieCacheDataSource
import com.example.tmdbapplication.data.repository.movies.datasource.local.MovieLocalDataSource
import com.example.tmdbapplication.data.repository.movies.datasource.remote.MovieRemoteDataSource
import com.example.tmdbapplication.domain.movies.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<MovieModel>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<MovieModel>? {
        //Download movies from api, clear db, save to db and cache, return new list.
    }

    suspend fun getMoviesFromApi(): List<MovieModel> {
        try {
            val response = movieRemoteDataSource.getMoviesFromNetwork()
            val body = response.body()
        } catch (e: Exception) {

        }
    }

    suspend fun getMoviesFromDB(): List<MovieModel> {
        lateinit var movieList: List<DBMovie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {

        }

        if (movieList.isNotEmpty()) {
            //Return movies from DB
        } else {
            //Download movies from API
            //Save new movies to DB
        }
    }

    suspend fun getMoviesFromCache(): List<MovieModel> {
        //Try to catch movie from cache, if is empty, try to catch movies from db.
    }
}