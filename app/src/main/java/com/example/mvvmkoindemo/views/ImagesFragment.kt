package com.example.mvvmkoindemo.views

import com.example.mvvmkoindemo.db.model.ImagesData
import com.example.mvvmkoindemo.util.replaceFragment
import com.example.mvvmkoindemo.viewmodel.ImagesViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmkoindemo.R
import com.example.mvvmkoindemo.databinding.FragmentImagesBinding
import kotlinx.android.synthetic.main.fragment_images.*
import org.koin.android.viewmodel.ext.android.viewModel

class ImagesFragment : Fragment(), ImageClickListener {

    private val imagesViewModel by viewModel<ImagesViewModel>()
    private lateinit var imagesAdapter: ImagesAdapter
    private lateinit var mViewDataBinding: FragmentImagesBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_images, container, false)
        val mRootView = mViewDataBinding.root
        mViewDataBinding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setView()
        removeBackButton()
        mViewDataBinding.viewModel = imagesViewModel
        imagesViewModel.getAllImages()
        imagesViewModel.imagesList.observe(viewLifecycleOwner, Observer {
            Log.d("@@images", it.size.toString())
            if (it.isNotEmpty() && it != null) {
                imagesAdapter.setCountries(it)
            }
        })

    }

    private fun removeBackButton() {
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeButtonEnabled(false)
    }

    private fun setView() {
        imagesAdapter = ImagesAdapter(context, this)
        rv_images.layoutManager = GridLayoutManager(activity, 2)
        rv_images.adapter = imagesAdapter
        rv_images.isNestedScrollingEnabled = false
    }

    override fun onItemClick(country : ImagesData) {
        (activity as MainActivity).replaceFragment(
            ImagesDetailsFragment.newInstance(country),
            R.id.fragment_container, "imagesdetails")
    }
}
