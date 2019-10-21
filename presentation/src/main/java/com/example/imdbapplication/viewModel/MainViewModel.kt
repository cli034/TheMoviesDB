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
        getMovieList()
    }

    fun getMovieList() {
//        compositeDisposable.add(
//            movieRepository.getMovieList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({this.test(it)}, {this.error(it)})
//        )

        compositeDisposable.add(
            movieRepository.getMovieList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::test, ::error)
        )
    }

    private fun test(movieResponse: MovieResponse) {
        if (movieResponse.results != null) {
            _moveListLiveData.value = movieResponse.results
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