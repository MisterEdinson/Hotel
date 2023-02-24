package com.example.hotel.ui.screens.reviews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel.domain.model.reviewsModel.ResponseReviewsItem
import com.example.hotel.domain.repository.Repository
import kotlinx.coroutines.launch

class ReviewsViewModel(private val repository: Repository) : ViewModel() {
    val repo: MutableLiveData<List<ResponseReviewsItem>> = MutableLiveData()

    fun getReviews() {
        viewModelScope.launch {
            val responce: List<ResponseReviewsItem> = repository.getReviews()
            repo.value = responce
        }
    }
}