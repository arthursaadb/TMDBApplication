package com.example.tmdbapplication.presentation.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.domain.movies.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _movieList = MutableLiveData<List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>> = _movieList

    fun getMovies() = viewModelScope.launch {
        _movieList.value = movieRepository.getMovies()
    }
}