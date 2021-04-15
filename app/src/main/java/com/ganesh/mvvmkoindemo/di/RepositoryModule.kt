package com.ganesh.mvvmkoindemo.di

import com.ganesh.mvvmkoindemo.repository.ImagesApi
import com.ganesh.mvvmkoindemo.db.ImagesDao
import com.ganesh.mvvmkoindemo.repository.ImagesRepository
import com.ganesh.mvvmkoindemo.repository.ImagesRepositoryImpl
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideImagesRepository(api: ImagesApi, context: Context, dao : ImagesDao): ImagesRepository {
        return ImagesRepositoryImpl(api, context, dao)
    }
    single { provideImagesRepository(get(), androidContext(), get()) }

}