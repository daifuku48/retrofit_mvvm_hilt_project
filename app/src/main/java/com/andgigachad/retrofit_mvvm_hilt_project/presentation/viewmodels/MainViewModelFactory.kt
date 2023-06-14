package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository

class MainViewModelFactory(
    private val savedStateHandle: SavedStateHandle,
    private val repository: FavoriteMealRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(savedStateHandle, repository) as T
    }
}