package com.example.mvvmkoindemo.repository

import com.example.mvvmkoindemo.db.model.ImagesData
import retrofit2.Response
import retrofit2.http.GET

interface ImagesApi {

    @GET("/v2/list")
    suspend fun getAllImages(): Response<List<ImagesData>>
}