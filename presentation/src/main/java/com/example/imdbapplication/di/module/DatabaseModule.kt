package com.example.imdbapplication.di.module

import androidx.room.Room
import com.example.data.localdb.AppDatabase
import com.example.imdbapplication.ImdbApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: ImdbApplication): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "database").build()
    }
}