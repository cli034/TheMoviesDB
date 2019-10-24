package com.example.imdbapplication.di.module

import com.example.imdbapplication.ImdbApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: ImdbApplication) {
    @Provides
    @Singleton
    fun providesApplication()= this.application
}