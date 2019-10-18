package com.example.imdbapplication.di.module

import com.example.data.MovieRepositoryImpl
import com.example.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideMovieRepository(impl: MovieRepositoryImpl): MovieRepository
}