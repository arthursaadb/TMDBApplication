package com.example.tmdbapplication.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbapplication.R
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.databinding.MovieListItemBinding
import com.squareup.picasso.Picasso

class MoviePagingAdapter :
    PagingDataAdapter<MovieModel, MoviePagingAdapter.ViewHolder>(MovieComparator) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: MovieListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.movie_list_item,
            parent,
            false
        )

        return ViewHolder(binding)
    }


    inner class ViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(movie: MovieModel) {
            setTitle(movie.title)
            setImage(movie.movieUrl)
            setDescription(movie.overview)
            setVoteAverage(movie.voteAverage)
        }

        private fun setVoteAverage(voteAverage: Double) {
            binding.voteAverageTextView.text = voteAverage.toString()
        }

        private fun setDescription(overview: String) {
            binding.descriptionTextView.text = overview
        }

        private fun setImage(movieUrl: String) {
            Picasso.get().load(movieUrl).into(binding.imageView)
        }

        private fun setTitle(title: String) {
            binding.titleTextView.text = title
        }
    }
}