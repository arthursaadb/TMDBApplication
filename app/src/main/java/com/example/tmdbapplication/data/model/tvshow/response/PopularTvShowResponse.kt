package com.example.tmdbapplication.data.model.tvshow.response

data class PopularTvShowResponse(
    val page: Int,
    val tvShowResponses: List<TvShowResponse>,
    val total_pages: Int,
    val total_results: Int
)