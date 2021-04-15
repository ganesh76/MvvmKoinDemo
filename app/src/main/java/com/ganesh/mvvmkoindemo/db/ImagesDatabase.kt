package com.ganesh.mvvmkoindemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ganesh.mvvmkoindemo.db.converter.*
import com.ganesh.mvvmkoindemo.db.model.*

@Database(
    entities = [ImagesData::class],
    version = 1, exportSchema = false
)

@TypeConverters(Converters::class)
abstract class ImagesDatabase : RoomDatabase() {
    abstract val imagesDao: ImagesDao
}