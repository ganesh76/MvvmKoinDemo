package com.ganesh.mvvmkoindemo.di

import com.ganesh.mvvmkoindemo.viewmodel.ImagesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build CountriesViewModel
    viewModel {
        ImagesViewModel(repository = get())
    }

}