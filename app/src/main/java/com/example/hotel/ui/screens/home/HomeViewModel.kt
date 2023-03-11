package com.example.hotel.ui.screens.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel.domain.model.detailsModel.ResponseItem
import com.example.hotel.domain.model.homeModel.Response
import com.example.hotel.domain.repository.Repository
import com.example.hotel.utils.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository):ViewModel() {
    val repo : MutableLiveData<List<ResponseItem>> = MutableLiveData()

    fun getAll(){
        viewModelScope.launch {
            try{
                val responce : List<ResponseItem> = repository.getAll()
                repo.value = responce
            }catch(_:Exception){

            }

        }
    }




}