package com.example.mvvmkoindemo.viewmodel

import com.example.mvvmkoindemo.db.model.ImagesData
import com.example.mvvmkoindemo.repository.ImagesRepository
import com.example.mvvmkoindemo.util.AppResult
import com.example.mvvmkoindemo.util.SingleLiveEvent
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ImagesViewModel(private val repository : ImagesRepository) : ViewModel() {

    val showLoading = ObservableBoolean()
    val imagesList = MutableLiveData<List<ImagesData>>()
    val showError = SingleLiveEvent<String>()

    fun getAllImages() {
        showLoading.set(true)
        viewModelScope.launch {
            val result =  repository.getAllImages()

            showLoading.set(false)
            when (result) {
                is AppResult.Success -> {
                    imagesList.value = result.successData
                    showError.value = null
                }
                is AppResult.Error -> showError.value = result.exception.message
            }
        }
    }
}