package com.example.mvvmkoindemo.db

import com.example.mvvmkoindemo.db.model.ImagesData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImagesDao {

    @Query("SELECT * FROM Images")
    fun findAll(): List<ImagesData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(images: List<ImagesData>)
}