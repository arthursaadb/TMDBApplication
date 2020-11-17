package com.example.tmdbapplication.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.tmdbapplication.R
import com.example.tmdbapplication.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding
    private lateinit var adapter: MoviePagingAdapter
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        observeMovies()
//        viewModel.getMovies()
        getMoviesPaging()
    }

    private fun getMoviesPaging() {
        adapter = MoviePagingAdapter()

        rv_movies.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.moviesPaging.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun observeMovies() {
        viewModel.movieList.observe(viewLifecycleOwner, Observer {
            binding.rvMovies.adapter = MovieAdapter(it)
        })
    }
}