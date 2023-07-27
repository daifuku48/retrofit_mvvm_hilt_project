package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.ErrorResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.SuccessResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsRecipeEntityUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.LiveResult
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.MutableLiveResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject


@HiltViewModel
class FavoritesMealsViewModel @Inject constructor(
    private val getAllMealsRecipeEntityUseCase: GetAllMealsRecipeEntityUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _recipeList = MutableLiveResult<List<RecipeEntity>>()
    val recipeList : LiveResult<List<RecipeEntity>>
        get() = _recipeList
    var loading = MutableLiveData<Boolean>()
    init{
        loading.value = false
        fetchData()
    }

    private fun fetchData()
    {
        viewModelScope.launch {
            try{
                val result = SuccessResult(getAllMealsRecipeEntityUseCase.execute())
                _recipeList.value = result
                loading.value = true
            } catch (e: UnknownHostException){
                val errorResult = ErrorResult<List<RecipeEntity>>(Exception("IllegalAccessError"))
                _recipeList.postValue(errorResult)
            }
        }
    }
}