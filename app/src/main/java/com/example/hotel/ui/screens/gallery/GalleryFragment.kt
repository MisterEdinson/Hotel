package com.example.hotel.ui.screens.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hotel.R
import com.example.hotel.domain.repository.Repository
import kotlinx.android.synthetic.main.fragment_gallery.*

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
            galleryAdapter?.setList(it.images as List<String>)
        })
    }

    private fun openActivityImage(item:String) {
        val intent = Intent(context,GalleryActivity::class.java)
        intent.putExtra("image",item)
        startActivity(intent)
//        val bundle = bundleOf("image" to item)
//        findNavController().navigate(R.id.galleryActivity, bundle)
    }

    private fun initAdapter() {
        galleryAdapter = GalleryAdapter(
            { item -> openActivityImage(item) }
        )
        rvGallery.apply {
            adapter = galleryAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }
}