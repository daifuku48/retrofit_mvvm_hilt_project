package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainSharedViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val categoryName = MutableLiveData<String>()
    private val categoryImage = MutableLiveData<String>()

    private val mealName = MutableLiveData<String>()

    fun setCategoryName(str: String) {
        categoryName.value = str
    }

    fun getCategoryName() = categoryName


    fun setCategoryImage(str: String) {
        categoryImage.value = str
    }

    fun getCategoryImage() = categoryImage

    fun setMealName(str: String){
        mealName.value = str
    }

    fun getMealName() = mealName
}