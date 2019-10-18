package com.example.data

import com.example.domain.model.MovieResponse
import com.example.domain.repository.MovieRepository
import io.reactivex.rxjava3.core.Single

class MovieRepositoryImpl(): MovieRepository {
    override fun getMovieList(): Single<MovieResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}