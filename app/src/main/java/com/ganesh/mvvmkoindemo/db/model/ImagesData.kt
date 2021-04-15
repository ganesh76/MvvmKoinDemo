package com.ganesh.mvvmkoindemo.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Images")
@Parcelize
class ImagesData (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val author: String?,
    val download_url: String?
) : Parcelable

