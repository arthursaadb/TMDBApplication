package com.example.tmdbapplication.data.mapper.movie

import com.example.tmdbapplication.data.mapper.Mapper
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.data.model.movie.db.DBMovie
import javax.inject.Inject

class DBMovieMapper @Inject constructor() : Mapper<DBMovie, MovieModel> {
    override fun map(input: DBMovie): MovieModel =
        MovieModel(
            overview = input.overview,
            posterPath = input.posterPath,
            releaseDate = input.releaseDate,
            title = input.title,
            voteAverage = input.voteAverage
        )

    override fun unmap(input: MovieModel): DBMovie =
        DBMovie(
            overview = input.overview,
            posterPath = input.posterPath,
            releaseDate = input.releaseDate,
            title = input.title,
            voteAverage = input.voteAverage
        )

    override fun mapList(input: List<DBMovie>?): List<MovieModel> =
        input?.map { map(it) }.orEmpty()

    override fun unmapList(input: List<MovieModel>?): List<DBMovie> =
        input?.map { unmap(it) }.orEmpty()
}