package com.example.data

import com.example.data.localdb.AppDatabase
import com.example.domain.model.Movie
import com.example.domain.model.MovieResponse
import com.example.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val appDatabase: AppDatabase
): MovieRepository {
    override fun getMovieList(): Single<MovieResponse> {
        return movieService.getMovieList()
    }

    override fun getMovieListFromDb(): Single<List<Movie>> {
        return appDatabase.movieDao().getMovieList()
    }

    override fun saveMovieListToDb(movieList: List<Movie>) {
        if (movieList.isNotEmpty()) {
            for (movie in movieList) {
                appDatabase.movieDao().insert(movie)
            }
        }
    }

    override fun deleteMovieFromDb(movie: Movie) {
        appDatabase.movieDao().delete(movie)
    }

    override fun deleteAllMoviesFromDb() {
        appDatabase.movieDao().deleteAll()
    }

}