package com.example.data

import com.example.domain.model.MovieResponse
import com.example.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService
): MovieRepository {
    override fun getMovieList(): Single<MovieResponse> {
        return movieService.getMovieList()
    }

}