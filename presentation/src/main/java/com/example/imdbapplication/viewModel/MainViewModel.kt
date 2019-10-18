package com.example.imdbapplication.viewModel

import androidx.lifecycle.ViewModel
import com.example.domain.repository.MovieRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}