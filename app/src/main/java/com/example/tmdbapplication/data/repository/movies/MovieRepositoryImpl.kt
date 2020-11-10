package com.example.tmdbapplication.data.repository.movies

import android.util.Log
import com.example.tmdbapplication.data.mapper.movie.DBMovieMapper
import com.example.tmdbapplication.data.mapper.movie.NetworkMovieMapper
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.data.repository.movies.datasource.cache.MovieCacheDataSource
import com.example.tmdbapplication.data.repository.movies.datasource.local.MovieLocalDataSource
import com.example.tmdbapplication.data.repository.movies.datasource.remote.MovieRemoteDataSource
import com.example.tmdbapplication.domain.movies.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val networkMovieMapper: NetworkMovieMapper,
    private val dbMovieMapper: DBMovieMapper
) : MovieRepository {
    override suspend fun getMovies(): List<MovieModel> = getMoviesFromCache()

    override suspend fun updateMovies(): List<MovieModel> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAllMovies()
        movieLocalDataSource.saveMoviesToDB(dbMovieMapper.unmapList(newListOfMovies))
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    override suspend fun loadSortedMovies(isAcending: Boolean): List<MovieModel> {
        lateinit var movieList: List<MovieModel>

        try {
            movieList = if (isAcending) {
                dbMovieMapper.mapList(movieLocalDataSource.getMoviesByVoteAverageAscending())
            } else {
                dbMovieMapper.mapList(movieLocalDataSource.getMoviesByVoteAverageDescending())
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromAPI(): List<MovieModel> {
        lateinit var movieList: List<MovieModel>

        try {
            movieRemoteDataSource.getMoviesFromNetwork().body()?.let {
                movieList = networkMovieMapper.mapList(it.results)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<MovieModel> {
        lateinit var movieList: List<MovieModel>
        try {
            movieList = dbMovieMapper.mapList(movieLocalDataSource.getMoviesFromDB())
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(dbMovieMapper.unmapList(movieList))
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<MovieModel> {
        lateinit var movieList: List<MovieModel>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}