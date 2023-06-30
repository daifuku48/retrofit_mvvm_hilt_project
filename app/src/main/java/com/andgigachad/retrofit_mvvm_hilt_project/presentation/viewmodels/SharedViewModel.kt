package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.SaveCategoryNameUseCase
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val saveCategoryNameUseCase: SaveCategoryNameUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}