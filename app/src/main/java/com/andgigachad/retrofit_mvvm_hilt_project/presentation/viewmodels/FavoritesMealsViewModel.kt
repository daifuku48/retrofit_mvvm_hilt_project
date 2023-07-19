package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.CheckInternetConnectionUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsRecipeEntityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoritesMealsViewModel @Inject constructor(
    private val checkInternetConnectionUseCase: CheckInternetConnectionUseCase,
    private val getAllMealsRecipeEntityUseCase: GetAllMealsRecipeEntityUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _recipeList = MutableLiveData<List<RecipeEntity>>()
    val recipeList : LiveData<List<RecipeEntity>>
        get() = _recipeList
    var loading = MutableLiveData<Boolean>()
    var networkConnection = MutableLiveData(true)
    init{
        loading.value = false
        fetchData()
    }

    private fun fetchData()
    {
        viewModelScope.launch {
            val result = getAllMealsRecipeEntityUseCase.execute()
            _recipeList.value = result
            loading.value = true

            while (true){
                networkConnection.value = checkInternetConnectionUseCase.execute()
                delay(10000L)
            }
        }
    }
}