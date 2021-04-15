package com.ganesh.mvvmkoindemo.views

import com.ganesh.mvvmkoindemo.db.model.ImagesData

interface ImageClickListener {
    fun onItemClick(imageData : ImagesData)
}