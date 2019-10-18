package com.example.imdbapplication.di.module

import com.example.data.MovieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ServiceModule {
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}