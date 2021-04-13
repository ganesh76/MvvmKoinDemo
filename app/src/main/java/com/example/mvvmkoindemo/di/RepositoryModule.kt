package com.example.mvvmkoindemo.di

import com.example.mvvmkoindemo.repository.ImagesApi
import com.example.mvvmkoindemo.db.ImagesDao
import com.example.mvvmkoindemo.repository.ImagesRepository
import com.example.mvvmkoindemo.repository.ImagesRepositoryImpl
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideImagesRepository(api: ImagesApi, context: Context, dao : ImagesDao): ImagesRepository {
        return ImagesRepositoryImpl(api, context, dao)
    }
    single { provideImagesRepository(get(), androidContext(), get()) }

}