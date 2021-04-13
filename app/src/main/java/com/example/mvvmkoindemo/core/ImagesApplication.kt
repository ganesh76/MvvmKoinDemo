package com.example.mvvmkoindemo.core

import android.app.Application
import com.example.mvvmkoindemo.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ImagesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
      startKoin {
            androidLogger()
            androidContext(this@ImagesApplication)
            modules(
                apiModule,
                viewModelModule,
                repositoryModule,
                networkModule,
                databaseModule
            )
        }
    }
}