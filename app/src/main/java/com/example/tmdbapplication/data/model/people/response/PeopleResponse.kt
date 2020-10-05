package com.example.tmdbapplication.data.model.people.response

import com.example.tmdbapplication.data.model.people.response.KnownForResponse

data class PeopleResponse(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_forResponse: List<KnownForResponse>,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
)