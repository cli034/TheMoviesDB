package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_table")
data class Movie(
    @SerializedName("poster_path")
    @Expose
    var poster_path: String? = null,

    @SerializedName("overview")
    @Expose
    var overview: String? = null,

    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("vote_count")
    @Expose
    var vote_count: Int? = null
)