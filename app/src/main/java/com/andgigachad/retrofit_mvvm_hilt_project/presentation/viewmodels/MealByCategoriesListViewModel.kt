package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsByCategoriesUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Meal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MealByCategoriesListViewModel @Inject constructor(
    private val getAllMealsByCategoriesUseCase: GetAllMealsByCategoriesUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _mealsList = MutableLiveData<List<Meal>>()
    val mealsList: LiveData<List<Meal>> = _mealsList
    var loading = MutableLiveData(false)
    fun fetchData(category: String) {
        viewModelScope.launch {
            delay(1000L)
            val domainResult = getAllMealsByCategoriesUseCase.execute(category = category).meals
            _mealsList.value = domainResult
            loading.value = true
        }
    }
}