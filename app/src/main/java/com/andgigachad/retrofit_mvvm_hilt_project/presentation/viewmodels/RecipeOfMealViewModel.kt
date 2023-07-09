package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.DetailMealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsByCategoriesUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetDetailMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
@ExperimentalCoroutinesApi
class RecipeOfMealViewModel @Inject constructor(
    private val getDetailMealUseCase: GetDetailMealUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private var _mealsList = MutableLiveData<DetailMealNetwork>()
    val mealsList: LiveData<DetailMealNetwork> = _mealsList
    var loading = MutableLiveData(false)

    fun fetchData(meal: String) {
        viewModelScope.launch {
            delay(1000L)
            val domainResult = getDetailMealUseCase.execute(meal).meals[0]
            _mealsList.value = domainResult
            loading.value = true
        }
    }

}