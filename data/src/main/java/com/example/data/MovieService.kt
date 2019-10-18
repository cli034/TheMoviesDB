package com.example.data

import com.example.domain.model.MovieResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {
    @GET("discover/movie?api_key=043e99a11301d5f6a49bf4325a24cda0&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false")
    fun getMovieList(): Single<MovieResponse>
}