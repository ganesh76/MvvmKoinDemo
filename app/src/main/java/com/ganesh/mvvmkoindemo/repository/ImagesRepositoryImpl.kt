package com.ganesh.mvvmkoindemo.repository

import com.ganesh.mvvmkoindemo.db.ImagesDao
import com.ganesh.mvvmkoindemo.db.model.ImagesData
import com.ganesh.mvvmkoindemo.util.AppResult
import com.ganesh.mvvmkoindemo.util.NetworkManager.isOnline
import com.ganesh.mvvmkoindemo.util.TAG
import com.ganesh.mvvmkoindemo.util.Utils.handleApiError
import com.ganesh.mvvmkoindemo.util.Utils.handleSuccess
import com.ganesh.mvvmkoindemo.util.noNetworkConnectivityError
import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImagesRepositoryImpl(
    private val api: ImagesApi,
    private val context: Context,
    private val dao: ImagesDao
) :
    ImagesRepository {

    override suspend fun getAllImages(): AppResult<List<ImagesData>> {
        if (isOnline(context)) {
            return try {
                val response = api.getAllImages()
                if (response.isSuccessful) {
                    //save the data
                    response.body()?.let {
                        withContext(Dispatchers.IO) { dao.add(it) }
                    }
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            //check in db if the data exists
            val data = getImagesDataFromCache()
            return if (data.isNotEmpty()) {
                Log.d(TAG, "from db")
                AppResult.Success(data)
            } else
            //no network
              context.noNetworkConnectivityError()
        }
    }

    private suspend fun getImagesDataFromCache(): List<ImagesData> {
        return withContext(Dispatchers.IO) {
            dao.findAll()
        }
    }

/*
This is another way of implementing where the source of data is db and api but we can always fetch from db
which will be updated with the latest data from api and also change findAll() return type to
LiveData<List<CountriesData>>
*/
    /* val data = dao.findAll()

     suspend fun getAllCountriesData() {
         withContext(Dispatchers.IO) {
             val response = api.getAllCountries()
             response.body()?.let {
                 withContext(Dispatchers.IO) { dao.add(it) }
             }
         }
     }*/

}