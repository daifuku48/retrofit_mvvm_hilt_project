package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.DeleteFavoriteMealEntityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteRecipeViewModel @Inject constructor(
    private val deleteFavoriteMealEntityUseCase : DeleteFavoriteMealEntityUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val loading = MutableLiveData<Boolean>()
    init {
        loading.value = false
    }

    fun delay(){
        viewModelScope.launch {
            delay(1000L)
            loading.value = true
        }
    }
    fun deleteRecipeFromFavorites(recipe: RecipeEntity){
        viewModelScope.launch {
            deleteFavoriteMealEntityUseCase.execute(recipe)
        }
    }

    fun setTextOfEngridients(recipe: RecipeEntity) : String {
        var textIngredientsAndMeasure = ""
        if (recipe.strIngredient1 != null && recipe.strIngredient1 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient1 + " " + recipe.strMeasure1 + "\n"
        }
        if (recipe.strIngredient2 != null && recipe.strIngredient2 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient2 + " " + recipe.strMeasure2 + "\n"
        }
        if (recipe.strIngredient3 != null && recipe.strIngredient3 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient3 + " " + recipe.strMeasure3 + "\n"
        }
        if (recipe.strIngredient4 != null && recipe.strIngredient4 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient4 + " " + recipe.strMeasure4 + "\n"
        }
        if (recipe.strIngredient5 != null && recipe.strIngredient5 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient5 + " " + recipe.strMeasure5 + "\n"
        }
        if (recipe.strIngredient6 != null && recipe.strIngredient6 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient6 + " " + recipe.strMeasure6 + "\n"
        }
        if (recipe.strIngredient7 != null && recipe.strIngredient7 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient7 + " " + recipe.strMeasure7 + "\n"
        }
        if (recipe.strIngredient8 != null && recipe.strIngredient8 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient8 + " " + recipe.strMeasure8 + "\n"
        }
        if (recipe.strIngredient9 != null && recipe.strIngredient9 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient9 + " " + recipe.strMeasure9 + "\n"
        }
        if (recipe.strIngredient10 != null && recipe.strIngredient10 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient10 + " " + recipe.strMeasure10 + "\n"
        }
        if (recipe.strIngredient11 != null && recipe.strIngredient11 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient11 + " " + recipe.strMeasure11 + "\n"
        }
        if (recipe.strIngredient12 != null && recipe.strIngredient12 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient12 + " " + recipe.strMeasure12 + "\n"
        }
        if (recipe.strIngredient13 != null && recipe.strIngredient13 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient13 + " " + recipe.strMeasure13 + "\n"
        }
        if (recipe.strIngredient14 != null && recipe.strIngredient14 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient14 + " " + recipe.strMeasure14 + "\n"
        }
        if (recipe.strIngredient15 != null && recipe.strIngredient15 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient15 + " " + recipe.strMeasure15 + "\n"
        }
        if (recipe.strIngredient16 != null && recipe.strIngredient16 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient16 + " " + recipe.strMeasure16 + "\n"
        }
        if (recipe.strIngredient17 != null && recipe.strIngredient17 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient17 + " " + recipe.strMeasure17 + "\n"
        }
        if (recipe.strIngredient18 != null && recipe.strIngredient18 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient18 + " " + recipe.strMeasure18 + "\n"
        }
        if (recipe.strIngredient19 != null && recipe.strIngredient19 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient19 + " " + recipe.strMeasure19 + "\n"
        }

        if (recipe.strIngredient20 != null && recipe.strIngredient20 != "")
        {
            textIngredientsAndMeasure += recipe.strIngredient20 + " " + recipe.strMeasure20 + "\n"
        }

        return textIngredientsAndMeasure.substring(0, textIngredientsAndMeasure.length - 1)
    }

}