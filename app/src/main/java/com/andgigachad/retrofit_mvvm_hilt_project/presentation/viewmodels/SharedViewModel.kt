package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var categoryName = MutableLiveData<String>()
    var categoryImage = MutableLiveData<String>()
    fun setCategoryName(str: String) {
        categoryName.value = str
    }

    fun getCategoryName(): LiveData<String> {
        return categoryName
    }

    fun setCategoryImage(str: String) {
        categoryImage.value = str
    }

    fun getCategoryImage(): LiveData<String> {
        return categoryName
    }
}