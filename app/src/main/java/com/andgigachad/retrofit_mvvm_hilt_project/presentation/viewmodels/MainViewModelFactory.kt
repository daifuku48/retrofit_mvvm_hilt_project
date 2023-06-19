package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.andgigachad.retrofit_mvvm_hilt_project.data.repository.FavoriteMealRepositoryImpl
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper

class MainViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    private val repository by lazy(LazyThreadSafetyMode.NONE){
        FavoriteMealRepositoryImpl(recipeService = RetrofitService,
        mapper = CategoriesMapper())
    }

    override fun <T : ViewModel> create(
        key: String, modelClass: Class<T>, handle: SavedStateHandle
    ): T {
        return MainViewModel(
            repository, handle
        ) as T
    }
}