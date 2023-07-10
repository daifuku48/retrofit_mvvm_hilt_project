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
class RecipeOfMealViewModel @Inject constructor(
    private val getDetailMealUseCase: GetDetailMealUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private var _mealsList = MutableLiveData<DetailMealNetwork>()
    val mealsList: LiveData<DetailMealNetwork> = _mealsList
    var loading = MutableLiveData(false)
    var textIngredientsAndMeasure = ""
    fun fetchData(meal: String) {
        viewModelScope.launch {
            delay(1000L)
            val domainResult = getDetailMealUseCase.execute(meal).meals[0]
            setTextIngredientsAndMeasure(domainResult)
            _mealsList.value = domainResult
            loading.value = true
        }
    }

    private fun setTextIngredientsAndMeasure(domainResult: DetailMealNetwork) {
        if (domainResult.strIngredient1 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient1 + " " + domainResult.strMeasure1 + "\n"
        }
        if (domainResult.strIngredient2 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient2 + " " + domainResult.strMeasure2 + "\n"
        }
        if (domainResult.strIngredient3 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient3 + " " + domainResult.strMeasure3 + "\n"
        }
        if (domainResult.strIngredient4 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient4 + " " + domainResult.strMeasure4 + "\n"
        }
        if (domainResult.strIngredient5 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient5 + " " + domainResult.strMeasure5 + "\n"
        }
        if (domainResult.strIngredient6 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient6 + " " + domainResult.strMeasure6 + "\n"
        }
        if (domainResult.strIngredient7 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient7 + " " + domainResult.strMeasure7 + "\n"
        }
        if (domainResult.strIngredient8 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient8 + " " + domainResult.strMeasure8 + "\n"
        }
        if (domainResult.strIngredient9 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient9 + " " + domainResult.strMeasure9 + "\n"
        }
        if (domainResult.strIngredient10 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient10 + " " + domainResult.strMeasure10 + "\n"
        }
        if (domainResult.strIngredient11 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient11 + " " + domainResult.strMeasure11 + "\n"
        }
        if (domainResult.strIngredient12 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient12 + " " + domainResult.strMeasure12 + "\n"
        }
        if (domainResult.strIngredient13 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient13 + " " + domainResult.strMeasure13 + "\n"
        }
        if (domainResult.strIngredient14 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient14 + " " + domainResult.strMeasure14 + "\n"
        }
        if (domainResult.strIngredient15 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient15 + " " + domainResult.strMeasure15 + "\n"
        }
        if (domainResult.strIngredient16 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient16 + " " + domainResult.strMeasure16 + "\n"
        }
        if (domainResult.strIngredient17 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient17 + " " + domainResult.strMeasure17 + "\n"
        }
        if (domainResult.strIngredient18 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient18 + " " + domainResult.strMeasure18 + "\n"
        }
        if (domainResult.strIngredient19 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient19 + " " + domainResult.strMeasure19 + "\n"
        }

        if (domainResult.strIngredient20 != null)
        {
            textIngredientsAndMeasure += domainResult.strIngredient20 + " " + domainResult.strMeasure20 + "\n"
        }
    }
}