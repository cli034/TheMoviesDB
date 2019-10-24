package com.example.data.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}