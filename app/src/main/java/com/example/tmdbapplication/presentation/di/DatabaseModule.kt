package com.example.tmdbapplication.presentation.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.tmdbapplication.data.db.MovieDao
import com.example.tmdbapplication.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): TMDBDatabase =
        Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "database.db"
        ).build()

    @Singleton
    @Provides
    fun providesMovieDao(database: TMDBDatabase): MovieDao =
        database.movieDao()

}