package com.example.hotel.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotel.domain.repository.Repository

class HomeViewModelFactory(val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create (modelClass : Class<T>) : T{
        return HomeViewModel(repository) as T
    }
}