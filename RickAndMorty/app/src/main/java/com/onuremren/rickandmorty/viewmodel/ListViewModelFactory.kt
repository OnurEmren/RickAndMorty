package com.onuremren.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onuremren.rickandmorty.repo.Repository

//viewmodel constructor içinde bir tanımlama yaparsak runtime error alırız. bunun için
//tanımlarımızı factoryde yapıyoruz.

class ListViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
     return ListViewModel(repository) as T
    }
}