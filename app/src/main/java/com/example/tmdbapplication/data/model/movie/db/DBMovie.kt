package com.example.tmdbapplication.data.model.movie.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class DBMovie(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val overview: String = "",
    val posterPath: String = "",
    val releaseDate: String = "",
    val title: String = ""
)