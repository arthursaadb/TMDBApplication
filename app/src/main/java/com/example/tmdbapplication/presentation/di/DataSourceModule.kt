package com.example.tmdbapplication.presentation.di

import com.example.tmdbapplication.data.repository.movies.datasource.cache.MovieCacheDataSource
import com.example.tmdbapplication.data.repository.movies.datasource.cache.MovieCacheDataSourceImpl
import com.example.tmdbapplication.data.repository.movies.datasource.local.MovieLocalDataSource
import com.example.tmdbapplication.data.repository.movies.datasource.local.MovieLocalDataSourceImpl
import com.example.tmdbapplication.data.repository.movies.datasource.remote.MovieRemoteDataSource
import com.example.tmdbapplication.data.repository.movies.datasource.remote.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindsMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    abstract fun bindsMovieLocalDataSource(movieLocalDataSourceImpl: MovieLocalDataSourceImpl): MovieLocalDataSource

    @Binds
    abstract fun bindsMovieCacheDataSource(movieCacheDataSourceImpl: MovieCacheDataSourceImpl): MovieCacheDataSource
}