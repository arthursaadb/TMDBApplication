package com.example.tmdbapplication.presentation.di

import com.example.tmdbapplication.data.repository.movies.MovieRepositoryImpl
import com.example.tmdbapplication.domain.movies.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}