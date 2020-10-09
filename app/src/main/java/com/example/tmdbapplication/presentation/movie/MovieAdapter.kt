package com.example.tmdbapplication.presentation.movie

import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.databinding.MovieListItemBinding

class MovieAdapter {


    inner class ViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(movie: MovieModel) {
        }
    }
}