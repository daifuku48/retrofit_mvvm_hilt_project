package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.DeleteFavoriteMealEntityUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteRecipeViewModel @Inject constructor(
    private val deleteFavoriteMealEntityUseCase : DeleteFavoriteMealEntityUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun deleteRecipeFromFavorites(recipe: RecipeEntity){
        viewModelScope.launch {
            deleteFavoriteMealEntityUseCase.execute(recipe)
        }
    }
}