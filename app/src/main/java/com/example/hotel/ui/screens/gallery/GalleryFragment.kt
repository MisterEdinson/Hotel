package com.example.hotel.ui.screens.gallery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hotel.R
import com.example.hotel.domain.repository.Repository
import com.example.hotel.utils.Constans
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.item_gallery.*
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryFragment : Fragment() {

    private lateinit var viewModel: GalleryViewModel
    private var galleryAdapter: GalleryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        val repository = Repository()
        val viewModelFactory = GalleryViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GalleryViewModel::class.java)
        viewModel.getGallery()
        viewModel.repo.observe(viewLifecycleOwner, Observer {
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