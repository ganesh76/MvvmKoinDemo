package com.example.mvvmkoindemo.views

import com.example.mvvmkoindemo.db.model.ImagesData

interface ImageClickListener {
    fun onItemClick(imageData : ImagesData)
}