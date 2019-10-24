package com.example.imdbapplication.di.component

import com.example.imdbapplication.ImdbApplication
import com.example.imdbapplication.di.ViewModelModule
import com.example.imdbapplication.di.module.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    RepositoryModule::class,
    NetworkModule::class,
    ServiceModule::class,
    DatabaseModule::class
])
interface AppComponent: AndroidInjector<ImdbApplication>