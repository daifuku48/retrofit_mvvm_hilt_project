package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsRecipeEntityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FavoritesMealsViewModel @Inject constructor(
    private val getAllMealsRecipeEntityUseCase: GetAllMealsRecipeEntityUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}