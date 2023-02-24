package com.example.hotel.ui.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel.domain.model.detailsModel.ResponseItem
import com.example.hotel.domain.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository):ViewModel() {
    val repo : MutableLiveData<List<ResponseItem>> = MutableLiveData()

    fun getAll(){
        viewModelScope.launch {
            val responce : List<ResponseItem> = repository.getAll()
            repo.value = responce
        }
    }
}