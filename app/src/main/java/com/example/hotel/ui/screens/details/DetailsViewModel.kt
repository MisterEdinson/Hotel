package com.example.hotel.ui.screens.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel.domain.model.homeNumber.Response
import com.example.hotel.domain.repository.Repository
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: Repository) : ViewModel() {
    val repo : MutableLiveData<Response> = MutableLiveData()

    fun getNumbers(id:Int){
        viewModelScope.launch {
            val responce : Response = repository.getNumber(id)
            repo.value = responce
        }
    }
}