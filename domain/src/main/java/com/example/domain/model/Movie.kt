package com.example.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("poster_path")
    @Expose
    var poster_path: String? = null,

    @SerializedName("overview")
    @Expose
    var overview: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("vote_count")
    @Expose
    var vote_count: Int? = null
)