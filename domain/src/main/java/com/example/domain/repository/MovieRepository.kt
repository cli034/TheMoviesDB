package com.example.domain.repository

import com.example.domain.model.MovieResponse
import io.reactivex.rxjava3.core.Single

interface MovieRepository {
    fun getMovieList(): Single<MovieResponse>
}