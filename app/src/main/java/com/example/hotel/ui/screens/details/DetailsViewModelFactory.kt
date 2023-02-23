package com.example.hotel.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotel.domain.repository.Repository

class DetailsViewModelFactory(val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create (modelClass : Class<T>) : T{
        return DetailsViewModel(repository) as T
    }
}
