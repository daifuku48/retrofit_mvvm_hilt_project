package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetDetailMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.InsertFavoriteMealEntityUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecipeOfMealViewModel @Inject constructor(
    private val getDetailMealUseCase: GetDetailMealUseCase,
    private val insertFavoriteMealEntityUseCase: InsertFavoriteMealEntityUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private var _meal = MutableLiveData<DetailMealNetwork>()
    val meal: LiveData<DetailMealNetwork> = _meal
    var loading = MutableLiveData(false)
    var textIngredientsAndMeasure = ""
    fun fetchData(meal: String) {
        viewModelScope.launch {
            delay(1000L)
            val domainResult = getDetailMealUseCase.execute(meal).meals[0]
            setTextIngredientsAndMeasure(domainResult)
            _meal.value = domainResult
            loading.value = true
        }
    }

    fun insertRecipeToFavorite(){
        val recipeEntity = RecipeEntity(
            strArea = meal.value?.strArea,
            strIngredient1 = meal.value?.strIngredient1,
            strIngredient2 = meal.value?.strIngredient2,
            strIngredient3 = meal.value?.strIngredient3,
            strIngredient4 = meal.value?.strIngredient4,
            strIngredient5 = meal.value?.strIngredient5,
            strIngredient6 = meal.value?.strIngredient6,
            strIngredient7 = meal.value?.strIngredient7,
            strIngredient8 = meal.value?.strIngredient8,
            strIngredient9 = meal.value?.strIngredient9,
            strIngredient10 = meal.value?.strIngredient10,
            strIngredient11 = meal.value?.strIngredient11,
            strIngredient12 = meal.value?.strIngredient12,
            strIngredient13 = meal.value?.strIngredient13,
            strIngredient14 = meal.value?.strIngredient14,
            strIngredient15 = meal.value?.strIngredient15,
            strIngredient16 = meal.value?.strIngredient16,
            strIngredient17 = meal.value?.strIngredient17,
            strIngredient18 = meal.value?.strIngredient18,
            strIngredient19 = meal.value?.strIngredient19,
            strIngredient20 = meal.value?.strIngredient20,
            strCategory = meal.value?.strCategory,
            strMeal = meal.value?.strMeal,
            strInstructions = meal.value?.strInstructions,
            strMealThumb = meal.value?.strMealThumb,
            strMeasure1 = meal.value?.strMeasure1,
            strMeasure2 = meal.value?.strMeasure2,
            strMeasure3 = meal.value?.strMeasure3,
            strMeasure4 = meal.value?.strMeasure4,
            strMeasure5 = meal.value?.strMeasure5,
            strMeasure6 = meal.value?.strMeasure6,
            strMeasure7 = meal.value?.strMeasure7,
            strMeasure8 = meal.value?.strMeasure8,
            strMeasure9 = meal.value?.strMeasure9,
            strMeasure10 = meal.value?.strMeasure10,
            strMeasure11 = meal.value?.strMeasure11,
            strMeasure12 = meal.value?.strMeasure12,
            strMeasure13 = meal.value?.strMeasure13,
            strMeasure14 = meal.value?.strMeasure14,
            strMeasure15 = meal.value?.strMeasure15,
            strMeasure16 = meal.value?.strMeasure16,
            strMeasure17 = meal.value?.strMeasure17,
            strMeasure18 = meal.value?.strMeasure18,
            strMeasure19 = meal.value?.strMeasure19,
            strMeasure20 = meal.value?.strMeasure20
        )
        viewModelScope.launch {
            insertFavoriteMealEntityUseCase.execute(recipeEntity)
        }
    }

    private fun setTextIngredientsAndMeasure(domainResult: DetailMealNetwork) {
        if (domainResult.strIngredient1 != null && domainResult.strIngredient1 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient1 + " " + domainResult.strMeasure1 + "\n"
        }
        if (domainResult.strIngredient2 != null && domainResult.strIngredient2 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient2 + " " + domainResult.strMeasure2 + "\n"
        }
        if (domainResult.strIngredient3 != null && domainResult.strIngredient3 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient3 + " " + domainResult.strMeasure3 + "\n"
        }
        if (domainResult.strIngredient4 != null && domainResult.strIngredient4 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient4 + " " + domainResult.strMeasure4 + "\n"
        }
        if (domainResult.strIngredient5 != null && domainResult.strIngredient5 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient5 + " " + domainResult.strMeasure5 + "\n"
        }
        if (domainResult.strIngredient6 != null && domainResult.strIngredient6 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient6 + " " + domainResult.strMeasure6 + "\n"
        }
        if (domainResult.strIngredient7 != null && domainResult.strIngredient7 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient7 + " " + domainResult.strMeasure7 + "\n"
        }
        if (domainResult.strIngredient8 != null && domainResult.strIngredient8 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient8 + " " + domainResult.strMeasure8 + "\n"
        }
        if (domainResult.strIngredient9 != null && domainResult.strIngredient9 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient9 + " " + domainResult.strMeasure9 + "\n"
        }
        if (domainResult.strIngredient10 != null && domainResult.strIngredient10 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient10 + " " + domainResult.strMeasure10 + "\n"
        }
        if (domainResult.strIngredient11 != null && domainResult.strIngredient11 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient11 + " " + domainResult.strMeasure11 + "\n"
        }
        if (domainResult.strIngredient12 != null && domainResult.strIngredient12 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient12 + " " + domainResult.strMeasure12 + "\n"
        }
        if (domainResult.strIngredient13 != null && domainResult.strIngredient13 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient13 + " " + domainResult.strMeasure13 + "\n"
        }
        if (domainResult.strIngredient14 != null && domainResult.strIngredient14 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient14 + " " + domainResult.strMeasure14 + "\n"
        }
        if (domainResult.strIngredient15 != null && domainResult.strIngredient15 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient15 + " " + domainResult.strMeasure15 + "\n"
        }
        if (domainResult.strIngredient16 != null && domainResult.strIngredient16 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient16 + " " + domainResult.strMeasure16 + "\n"
        }
        if (domainResult.strIngredient17 != null && domainResult.strIngredient17 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient17 + " " + domainResult.strMeasure17 + "\n"
        }
        if (domainResult.strIngredient18 != null && domainResult.strIngredient18 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient18 + " " + domainResult.strMeasure18 + "\n"
        }
        if (domainResult.strIngredient19 != null && domainResult.strIngredient19 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient19 + " " + domainResult.strMeasure19 + "\n"
        }

        if (domainResult.strIngredient20 != null && domainResult.strIngredient20 != "") {
            textIngredientsAndMeasure += domainResult.strIngredient20 + " " + domainResult.strMeasure20 + "\n"
        }

        textIngredientsAndMeasure = textIngredientsAndMeasure.substring(0, textIngredientsAndMeasure.length - 1)
    }
}