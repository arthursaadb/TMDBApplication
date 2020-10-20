package com.example.tmdbapplication.data.mapper.movie

import com.example.tmdbapplication.data.mapper.Mapper
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.data.model.movie.network.NetworkMovie
import javax.inject.Inject

class NetworkMovieMapper @Inject constructor() : Mapper<NetworkMovie, MovieModel> {
    override fun map(input: NetworkMovie): MovieModel =
        MovieModel(
            overview = input.overview ?: "",
            posterPath = input.posterPath ?: "",
            releaseDate = input.releaseDate ?: "",
            title = input.title ?: ""
        )

    override fun unmap(input: MovieModel): NetworkMovie =
        NetworkMovie(
            overview = input.overview,
            posterPath = input.posterPath,
            releaseDate = input.releaseDate,
            title = input.title
        )

    override fun mapList(input: List<NetworkMovie>?): List<MovieModel> =
        input?.map { map(it) }.orEmpty()

    override fun unmapList(input: List<MovieModel>?): List<NetworkMovie> =
        input?.map { unmap(it) }.orEmpty()
}