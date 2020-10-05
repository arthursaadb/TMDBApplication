package com.example.tmdbapplication.data.model.people.response

import com.example.tmdbapplication.data.model.people.response.PeopleResponse

data class PopularPeopleResponse(
    val page: Int,
    val peopleResponses: List<PeopleResponse>,
    val total_pages: Int,
    val total_results: Int
)