package com.example.mvvmkoindemo.di

import com.example.mvvmkoindemo.repository.ImagesApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideCountriesApi(retrofit: Retrofit): ImagesApi {
        return retrofit.create(ImagesApi::class.java)
    }
    single { provideCountriesApi(get()) }

}