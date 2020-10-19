package com.example.tmdbapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbapplication.data.model.movie.db.DBMovie

@Database(entities = [DBMovie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}