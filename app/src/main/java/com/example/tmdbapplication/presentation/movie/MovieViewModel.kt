package com.example.tmdbapplication.presentation.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbapplication.domain.movies.usecases.GetMoviesUseCase
import com.example.tmdbapplication.domain.movies.usecases.UpdateMovieUseCase

class MovieViewModel @ViewModelInject constructor(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        emit(getMovieUseCase.execute())
    }

    fun updateMovieList() = liveData {
        emit(updateMovieUseCase.execute())
    }
}