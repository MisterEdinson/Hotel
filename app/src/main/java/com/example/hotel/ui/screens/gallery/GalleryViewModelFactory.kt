package com.example.hotel.ui.screens.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotel.domain.repository.Repository
import com.example.hotel.ui.screens.home.HomeViewModel

class GalleryViewModelFactory(val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create (modelClass : Class<T>) : T{
        return GalleryViewModel(repository) as T
    }
}