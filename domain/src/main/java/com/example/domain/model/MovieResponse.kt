package com.example.domain.model

data class MovieResponse(
    var page: Int? = null,
    var results: List<Movie>? = null,
    var total_results: Int? = null,
    var total_pages: Int? = null
)