package com.example.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page")
    @Expose
    var page: Int? = null,

    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null,

    @SerializedName("total_results")
    @Expose
    var total_results: Int? = null,

    @SerializedName("total_pages")
    @Expose
    var total_pages: Int? = null
)