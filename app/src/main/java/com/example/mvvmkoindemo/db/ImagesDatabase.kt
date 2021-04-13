package com.example.mvvmkoindemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmkoindemo.db.converter.*
import com.example.mvvmkoindemo.db.model.*

@Database(
    entities = [ImagesData::class],
    version = 1, exportSchema = false
)

@TypeConverters(Converters::class)
abstract class ImagesDatabase : RoomDatabase() {
    abstract val imagesDao: ImagesDao
}