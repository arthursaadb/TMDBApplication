package com.example.tmdbapplication.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.tmdbapplication.R
import com.example.tmdbapplication.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        observeMovies()
        viewModel.getMovies()
    }

    private fun observeMovies() {
        viewModel.movieList.observe(this, Observer {
            binding.rvMovies.adapter = MovieAdapter(it)
        })
    }
}