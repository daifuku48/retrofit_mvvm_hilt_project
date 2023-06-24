package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsByCategoriesUseCase
import javax.inject.Inject

class MealByCategoriesListViewModel @Inject constructor(
    private val getAllMealsByCategoriesUseCase: GetAllMealsByCategoriesUseCase,
    private val savedStateHandle: SavedStateHandle
) {
}