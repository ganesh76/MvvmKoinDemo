package com.ganesh.mvvmkoindemo.views

import com.ganesh.mvvmkoindemo.db.model.ImagesData
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ganesh.mvvmkoindemo.R
import com.ganesh.mvvmkoindemo.databinding.ImagesRowBinding


class ImagesAdapter(val context: Context?,
                    val clickListener: ImageClickListener
) : RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>() {

    var imagesList: List<ImagesData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val viewBinding: ImagesRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.images_row, parent, false
        )
        return ImagesViewHolder(viewBinding)
    }


    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setCountries(countries: List<ImagesData>) {
        this.imagesList = countries
        notifyDataSetChanged()
    }

    inner class ImagesViewHolder(private val viewBinding: ImagesRowBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(position: Int) {
            val row = imagesList[position]
            viewBinding.imageData = row
            Glide.with(context!!)
                .load(row.download_url)
                .override(200, 200)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewBinding.image)
           // viewBinding.imageClickInterface = clickListener // on click add more details in next fragment
        }
    }

}


