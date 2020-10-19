package com.example.tmdbapplication.domain.movies.usecases

import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.domain.movies.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<MovieModel> = movieRepository.getMovies()
}