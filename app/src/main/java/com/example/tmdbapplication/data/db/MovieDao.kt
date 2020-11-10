package com.example.tmdbapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbapplication.data.model.movie.db.DBMovie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<DBMovie>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movie_table")
    suspend fun getMovies(): List<DBMovie>

    @Query("SELECT * FROM movie_table ORDER BY voteAverage ASC")
    suspend fun loadMoviesByVoteAverageAscending(): List<DBMovie>

    @Query("SELECT * FROM movie_table ORDER BY voteAverage DESC")
    suspend fun loadMoviesByVoteAverageDescending(): List<DBMovie>
}