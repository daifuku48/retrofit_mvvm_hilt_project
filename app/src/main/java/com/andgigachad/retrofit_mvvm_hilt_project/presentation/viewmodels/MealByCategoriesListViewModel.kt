package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.ErrorResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.SuccessResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsByCategoriesUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.LiveResult
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.MutableLiveResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MealByCategoriesListViewModel @Inject constructor(
    private val getAllMealsByCategoriesUseCase: GetAllMealsByCategoriesUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _mealsList = MutableLiveResult<List<MealNetwork>>()
    val mealsList: LiveResult<List<MealNetwork>> = _mealsList
    var loading = MutableLiveData(false)

    fun fetchData(category: String) {
        viewModelScope.launch {
            delay(1000L)
            try {
            val domainResult = SuccessResult(getAllMealsByCategoriesUseCase.execute(category).meals)
            _mealsList.value = domainResult
            loading.value = true
            } catch (e: UnknownHostException){
                _mealsList.value = ErrorResult<List<MealNetwork>>(Exception("UnknownHostException"))
            }
        }
    }
}