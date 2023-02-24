package com.example.hotel.ui.screens.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel.domain.model.galleryModel.ResponseImages
import com.example.hotel.domain.repository.Repository
import kotlinx.coroutines.launch

class GalleryViewModel (private val repository: Repository):ViewModel() {
    val repo : MutableLiveData<ResponseImages> = MutableLiveData()

    fun getGallery(){
        viewModelScope.launch {
            val responce : ResponseImages = repository.getGallery()
            repo.value = responce
        }
    }
}