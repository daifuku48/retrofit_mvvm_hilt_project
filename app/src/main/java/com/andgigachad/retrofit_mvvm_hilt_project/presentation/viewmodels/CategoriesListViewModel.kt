package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.domain.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class CategoriesListViewModel @Inject constructor(
    private val getAllCategoriesMealUseCase: GetAllCategoriesMealUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var categoriesRecipe : MutableLiveData<CategoriesDomain>? = null
    var loading = MutableLiveData(false)
    var recipeScrollPosition = 0
}