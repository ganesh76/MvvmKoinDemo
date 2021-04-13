package com.example.mvvmkoindemo.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mvvmkoindemo.R
import com.example.mvvmkoindemo.databinding.FragmentImageDetailsBinding
import com.example.mvvmkoindemo.db.model.ImagesData

class ImagesDetailsFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(data: ImagesData) = ImagesDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("image_row", data)
            }
        }
    }

    private var country: ImagesData? = null
    private lateinit var mViewDataBinding: FragmentImageDetailsBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_image_details, container, false)
        val mRootView = mViewDataBinding.root
        mViewDataBinding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        enableBackButton()
    }

    private fun enableBackButton() {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeButtonEnabled(true)
    }
    
}