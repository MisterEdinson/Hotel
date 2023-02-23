package com.example.hotel.data.web

import com.example.hotel.domain.model.home.ResponseItem
import com.example.hotel.domain.model.homeNumber.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET("post/hotel/{id}")
    suspend fun getOne(
        @Path("id") id: Int
    ): Response

    @GET("post/hotel/")
    suspend fun getAll(): List<ResponseItem>
}