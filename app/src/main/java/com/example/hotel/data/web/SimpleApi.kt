package com.example.hotel.data.web

import com.example.hotel.domain.model.detailsModel.ResponseItem
import com.example.hotel.domain.model.galleryModel.ResponseImages
import com.example.hotel.domain.model.homeModel.Response
import com.example.hotel.domain.model.reviewsModel.ResponseReviewsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET("dsadasdsavcvcxrew312fds/hotel/{id}")
    suspend fun getOne(
        @Path("id") id: Int
    ): Response

    @GET("dsadasdsavcvcxrew312fds/hotel/")
    suspend fun getAll(): List<ResponseItem>

    @GET("dsadasdsavcvcxrew312fds/gallery/")
    suspend fun getGallery(): ResponseImages

    @GET("dsadasdsavcvcxrew312fds/reviews/")
    suspend fun getReviews(): List<ResponseReviewsItem>
}