package com.ganesh.mvvmkoindemo.di

import com.ganesh.mvvmkoindemo.db.ImagesDao
import com.ganesh.mvvmkoindemo.db.ImagesDatabase
import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): ImagesDatabase {
       return Room.databaseBuilder(application, ImagesDatabase::class.java, "images")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideImagesDao(database: ImagesDatabase): ImagesDao {
        return  database.imagesDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideImagesDao(get()) }


}
