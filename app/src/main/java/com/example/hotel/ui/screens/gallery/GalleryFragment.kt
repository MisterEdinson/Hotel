package com.example.hotel.ui.screens.gallery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.hotel.R
import com.example.hotel.domain.repository.Repository
import com.example.hotel.utils.Constans
import com.example.hotel.utils.Constans.Companion.BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*
import kotlinx.android.synthetic.main.item_gallery.*
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryFragment : Fragment() {

    private lateinit var viewModel: GalleryViewModel
    private var galleryAdapter: GalleryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        val repository = Repository()
        val viewModelFactory = GalleryViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GalleryViewModel::class.java)
        viewModel.getGallery()
        //Glide.with(this).load(R.drawable.more).into(imgBig)
        viewModel.repo.observe(viewLifecycleOwner, Observer {
            imgBig.visibility = INVISIBLE
            galleryAdapter?.setList(it.images as List<String>)
        })
    }

    private fun initAdapter() {
        galleryAdapter = GalleryAdapter()
        rvGallery.apply {
            adapter = galleryAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }
}