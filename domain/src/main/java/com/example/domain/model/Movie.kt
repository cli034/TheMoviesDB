package com.example.domain.model

data class Movie(
    var poster_path: String? = null,
    var overview: String? = null,
    var id: Int? = null,
    var original_title: String? = null,
    var title: String? = null,
    var vote_count: Int? = null
)