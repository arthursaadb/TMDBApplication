package com.example.tmdbapplication.data.repository.movies

import android.util.Log
import com.example.tmdbapplication.data.mapper.movie.DBMovieMapper
import com.example.tmdbapplication.data.mapper.movie.NetworkMovieMapper
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
    private val movieCacheDataSource: MovieCacheDataSource,
    private val networkMovieMapper: NetworkMovieMapper,
    private val dbMovieMapper: DBMovieMapper
) : MovieRepository {
    override suspend fun getMovies(): List<MovieModel> = getMoviesFromCache()

    override suspend fun updateMovies(): List<MovieModel> {
        var movies: List<MovieModel> = listOf()

        try {
            movies = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(dbMovieMapper.unmapList(movies))
            movieCacheDataSource.saveMoviesToCache(movies)
        } catch (e: Exception) {

        }

        return movies
    }

    suspend fun getMoviesFromApi(): List<MovieModel> {
        var movies: List<MovieModel> = listOf()

        try {
            val response = movieRemoteDataSource.getMoviesFromNetwork()
            val body = response.body()
            movies = networkMovieMapper.mapList(body?.results)
        } catch (e: Exception) {
            Log.e("exception", e.message.toString())
        }

        return movies
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

    suspend fun getMoviesFromCache(): List<MovieModel> = movieCacheDataSource.getMoviesFromCache()
}