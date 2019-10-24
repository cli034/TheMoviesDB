package com.example.imdbapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Movie
import com.example.domain.model.MovieResponse
import com.example.domain.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _moveListLiveData = MutableLiveData<List<Movie>>()
    val movieListLiveData: LiveData<List<Movie>> get() = _moveListLiveData

    init {
        getMovieListFromDb()
    }

    fun getMovieListFromDb() {
//        compositeDisposable.add(
//            movieRepository.getMovieListFromDb()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({this.loadMovieListLiveDataFromApi(it)}, {this.error(it)})
//        )

        compositeDisposable.add(
            movieRepository.getMovieListFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::loadMovieListLiveDataFromDb, ::error)
        )
    }

    fun getMovieListFromApi() {
        compositeDisposable.add(
            movieRepository.getMovieList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::loadMovieListLiveDataFromApi, ::error)
        )
    }

    private fun loadMovieListLiveDataFromDb(movieList: List<Movie>) {
        if (movieList.isNotEmpty()) {
            _moveListLiveData.value = movieList
        } else {
            getMovieListFromApi()
        }
    }

    private fun loadMovieListLiveDataFromApi(movieResponse: MovieResponse) {
        if (movieResponse.results != null) {
            val movieList = movieResponse.results?.sortedByDescending { it.vote_count }
            _moveListLiveData.value = movieList
            Thread {
                movieRepository.saveMovieListToDb(movieList!!)
            }.start()
        }
    }

    private fun error(throwable: Throwable) {
        Log.d("error", throwable.toString())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}