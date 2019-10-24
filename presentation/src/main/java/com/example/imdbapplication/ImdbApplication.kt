package com.example.imdbapplication

import android.app.Application
import com.example.imdbapplication.di.component.DaggerAppComponent
import com.example.imdbapplication.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ImdbApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
//        DaggerAppComponent.create().inject(this)
        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

}