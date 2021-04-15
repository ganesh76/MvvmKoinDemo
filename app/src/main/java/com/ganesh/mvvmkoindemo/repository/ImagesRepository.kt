package com.ganesh.mvvmkoindemo.repository

import com.ganesh.mvvmkoindemo.db.model.ImagesData
import com.ganesh.mvvmkoindemo.util.AppResult

interface ImagesRepository {
    suspend fun getAllImages() : AppResult<List<ImagesData>>
}
