package com.example.mvvmkoindemo.repository

import com.example.mvvmkoindemo.db.model.ImagesData
import com.example.mvvmkoindemo.util.AppResult

interface ImagesRepository {
    suspend fun getAllImages() : AppResult<List<ImagesData>>
}
