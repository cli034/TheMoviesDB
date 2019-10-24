package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.model.MovieResponse
import io.reactivex.Single

interface MovieRepository {
    fun getMovieList(): Single<MovieResponse>

    fun getMovieListFromDb(): Single<List<Movie>>

    fun saveMovieListToDb(movieList: List<Movie>)

    fun deleteMovieFromDb(movie: Movie)

    fun deleteAllMoviesFromDb()
}