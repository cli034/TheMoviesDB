package com.example.imdbapplication.di.component

import com.example.imdbapplication.ImdbApplication
import com.example.imdbapplication.di.ActivityBuilderModule
import com.example.imdbapplication.di.module.NetworkModule
import com.example.imdbapplication.di.module.RepositoryModule
import com.example.imdbapplication.di.module.ServiceModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBuilderModule::class,
    RepositoryModule::class,
    NetworkModule::class,
    ServiceModule::class
])
interface AppComponent: AndroidInjector<ImdbApplication>