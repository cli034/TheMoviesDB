package com.example.imdbapplication.di

import com.example.imdbapplication.ImdbApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBuilderModule::class
])
interface AppComponent: AndroidInjector<ImdbApplication>