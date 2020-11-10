package com.example.tmdbapplication.presentation.movie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.tmdbapplication.R
import com.example.tmdbapplication.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {
    private lateinit var binding: ActivityMovieBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.activity_movie)

        observeMovies()
        viewModel.getMovies()
    }

    private fun observeMovies() {
        viewModel.movieList.observe(this, Observer {
            binding.rvMovies.adapter = MovieAdapter(it)
        })
    }
}