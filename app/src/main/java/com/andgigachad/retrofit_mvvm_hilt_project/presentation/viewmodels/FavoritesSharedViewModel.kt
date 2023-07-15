package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesSharedViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel()  {
    private var recipe = MutableLiveData<RecipeEntity>()

    fun setRecipe(recipeEntity: RecipeEntity) {
        recipe.value = recipeEntity
    }

    fun getRecipe() = recipe

}