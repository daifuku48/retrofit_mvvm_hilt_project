package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.ErrorResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.SuccessResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.BaseViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.LiveResult
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.MutableLiveResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class CategoriesListViewModel @Inject constructor(
    private val getAllCategoriesMealUseCase: GetAllCategoriesMealUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private var _categoriesList = MutableLiveResult<List<Category>>()
    var categoriesList: LiveResult<List<Category>> = _categoriesList
    var loading = MutableLiveData(false)
    init{
        fetchData()
    }

    fun restartQuery() {
        fetchData()
    }

    private fun fetchData() {

        viewModelScope.launch {
            delay(1000L)
            try {
                val domainResult = SuccessResult(getAllCategoriesMealUseCase.execute().categories)
                _categoriesList.postValue(domainResult)
            } catch (e: UnknownHostException){
                val errorResult = ErrorResult<List<Category>>(Exception("IllegalAccessError"))
                _categoriesList.postValue(errorResult)
            }

            loading.value = true
        }
    }
}