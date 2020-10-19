package com.example.tmdbapplication.data.mapper.movie

import com.example.tmdbapplication.data.mapper.Mapper
import com.example.tmdbapplication.data.model.movie.MovieModel
import com.example.tmdbapplication.data.model.movie.db.DBMovie

class DBMovieMapper :
    Mapper<DBMovie, MovieModel> {
    override fun map(input: DBMovie): MovieModel =
        MovieModel(
            overview = input.overview,
            posterPath = input.posterPath,
            releaseDate = input.releaseDate,
            title = input.title
        )

    override fun unmap(input: MovieModel): DBMovie =
        DBMovie(
            overview = input.overview,
            posterPath = input.posterPath,
            releaseDate = input.releaseDate,
            title = input.title
        )

    override fun mapList(input: List<DBMovie>?): List<MovieModel> =
        input?.map { map(it) }.orEmpty()

    override fun unmapList(input: List<MovieModel>?): List<DBMovie> =
        input?.map { unmap(it) }.orEmpty()
}