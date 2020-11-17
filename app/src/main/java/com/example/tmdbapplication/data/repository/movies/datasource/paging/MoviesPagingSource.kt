package com.example.tmdbapplication.data.repository.movies.datasource.paging

import androidx.paging.PagingSource
import com.example.tmdbapplication.data.api.TMDBService
import com.example.tmdbapplication.data.mapper.movie.NetworkMovieMapper
import com.example.tmdbapplication.data.model.movie.MovieModel
import javax.inject.Inject

class MoviesPagingSource @Inject constructor(
    private val tmdbService: TMDBService,
    private val mapper: NetworkMovieMapper
) :
    PagingSource<Int, MovieModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        return try {
            val nextPage = params.key ?: 1
            val response = tmdbService.getPopularMoviesPaging(nextPage)
            val movies = mapper.mapList(response.body()?.results)


            LoadResult.Page(
                data = movies,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}