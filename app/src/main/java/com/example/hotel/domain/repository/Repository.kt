package com.example.hotel.domain.repository

import com.example.hotel.data.web.RetrofitInstance
import com.example.hotel.domain.model.home.ResponseItem
import com.example.hotel.domain.model.homeNumber.Response

class Repository {
    suspend fun getNumber(id:Int): Response {
        return RetrofitInstance.api.getOne(id)
    }
    suspend fun getAll(): List<ResponseItem> {
        return RetrofitInstance.api.getAll()
    }
}