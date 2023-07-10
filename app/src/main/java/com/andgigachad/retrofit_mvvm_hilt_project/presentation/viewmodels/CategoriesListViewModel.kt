package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesListViewModel @Inject constructor(
    private val getAllCategoriesMealUseCase: GetAllCategoriesMealUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private var _categoriesList = MutableLiveData<List<Category>>()
    var categoriesList: LiveData<List<Category>> = _categoriesList
    var loading = MutableLiveData(false)

    init{
        fetchData()
    }

    private fun fetchData() {

        viewModelScope.launch {
            delay(1000L)
            val domainResult = getAllCategoriesMealUseCase.execute().categories
            _categoriesList.value = domainResult
            loading.value = true
        }
    }
}