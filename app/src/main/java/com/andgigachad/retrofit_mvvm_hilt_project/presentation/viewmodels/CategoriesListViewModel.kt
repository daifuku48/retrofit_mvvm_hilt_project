package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.CheckInternetConnectionUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.NullPointerException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class CategoriesListViewModel @Inject constructor(
    private val checkInternetConnectionUseCase: CheckInternetConnectionUseCase,
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
            try {
                val domainResult = getAllCategoriesMealUseCase.execute().categories
                _categoriesList.value = domainResult
            } catch (e: UnknownHostException){
                Log.d("error", e.message.toString())
            }

            loading.value = true
        }
    }
}