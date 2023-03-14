package com.example.hotel.domain.repository


import com.example.hotel.data.web.RetrofitInstance
import com.example.hotel.domain.model.detailsModel.ResponseItem
import com.example.hotel.domain.model.galleryModel.ResponseImages
import com.example.hotel.domain.model.homeModel.Response
import com.example.hotel.domain.model.reviewsModel.ResponseReviewsItem

class Repository{
    suspend fun getNumber(id:Int): Response {
        return RetrofitInstance.api.getOne(id)
    }
    suspend fun getAll(): List<ResponseItem> {
        return RetrofitInstance.api.getAll()
    }
    suspend fun getReviews(): List<ResponseReviewsItem> {
        return RetrofitInstance.api.getReviews()
    }
    suspend fun getGallery(): ResponseImages{
        return RetrofitInstance.api.getGallery()
    }
}