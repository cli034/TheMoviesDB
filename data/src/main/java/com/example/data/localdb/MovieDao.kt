package com.example.data.localdb

import androidx.room.*
import com.example.domain.model.Movie
import io.reactivex.Single

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies_table")
    fun getMovieList(): Single<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("DELETE FROM movies_table")
    fun deleteAll()
}