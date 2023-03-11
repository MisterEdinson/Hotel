package com.example.hotel.ui.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hotel.R
import com.example.hotel.domain.model.detailsModel.ResponseItem
import com.example.hotel.domain.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var homeAdapter: HomeAdapterNumber? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        val repository = Repository()
        val viewModelFactory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        viewModel.getAll()
        viewModel.repo.observe(viewLifecycleOwner, Observer {
            homeAdapter?.setList(it as List<ResponseItem>)
            progressBar.visibility = View.INVISIBLE
        })
    }

    private fun initAdapter() {
        homeAdapter = HomeAdapterNumber()
        rvHome.apply {
            adapter = homeAdapter
            layoutManager = GridLayoutManager(activity, 1)
        }
    }
}