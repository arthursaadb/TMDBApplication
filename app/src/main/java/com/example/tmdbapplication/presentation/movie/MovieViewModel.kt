package com.example.tmdbapplication.presentation.movie

import android.graphics.Movie
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.domain.movies.usecases.GetMoviesUseCase
import com.example.tmdbapplication.domain.movies.usecases.UpdateMovieUseCase
import kotlinx.coroutines.launch

class MovieViewModel @ViewModelInject constructor(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {
    private val _movieList = MutableLiveData<List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>> = _movieList

    fun getMovies() = viewModelScope.launch {
        _movieList.value = getMovieUseCase.execute()
    }
}