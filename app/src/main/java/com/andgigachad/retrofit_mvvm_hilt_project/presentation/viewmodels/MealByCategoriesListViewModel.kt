package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.CheckInternetConnectionUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsByCategoriesUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealByCategoriesListViewModel @Inject constructor(
    private val checkInternetConnectionUseCase: CheckInternetConnectionUseCase,
    private val getAllMealsByCategoriesUseCase: GetAllMealsByCategoriesUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _mealsList = MutableLiveData<List<MealNetwork>>()
    val mealsList: LiveData<List<MealNetwork>> = _mealsList
    var loading = MutableLiveData(false)

    var networkConnection = MutableLiveData(true)

    fun fetchData(category: String) {
        viewModelScope.launch {
            delay(1000L)
            val domainResult = getAllMealsByCategoriesUseCase.execute(category).meals
            _mealsList.value = domainResult
            loading.value = true

            while (true){
                networkConnection.value = checkInternetConnectionUseCase.execute()
                delay(10000L)
            }
        }
    }
}