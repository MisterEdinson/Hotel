package com.example.hotel.ui.screens.reviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hotel.R
import com.example.hotel.domain.model.detailsModel.ResponseItem
import com.example.hotel.domain.model.reviewsModel.ResponseReviewsItem
import com.example.hotel.domain.repository.Repository
import com.example.hotel.ui.screens.home.HomeAdapterNumber
import com.example.hotel.ui.screens.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_reviews.*

class ReviewsFragment : Fragment() {
    private lateinit var viewModel: ReviewsViewModel
    private var reviewsAdapter: ReviewsAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        val repository = Repository()
        val viewModelFactory = ReviewsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ReviewsViewModel::class.java)
        viewModel.getReviews()
        viewModel.repo.observe(viewLifecycleOwner, Observer {
            reviewsAdapter?.setList(it as List<ResponseReviewsItem>)
        })
    }

    private fun initAdapter(){
        reviewsAdapter = ReviewsAdapter()
        rvReviews.apply {
            adapter = reviewsAdapter
            layoutManager = GridLayoutManager(activity, 1)
        }
    }
}