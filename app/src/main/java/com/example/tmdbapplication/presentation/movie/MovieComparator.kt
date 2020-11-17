package com.example.tmdbapplication.presentation.movie

import androidx.recyclerview.widget.DiffUtil
import com.example.tmdbapplication.data.model.movie.MovieModel

object MovieComparator : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem == newItem
    }
}