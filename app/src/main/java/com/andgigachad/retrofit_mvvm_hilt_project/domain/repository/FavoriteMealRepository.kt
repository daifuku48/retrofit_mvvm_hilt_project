package com.andgigachad.retrofit_mvvm_hilt_project.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingData
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.DetailMealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category

interface FavoriteMealRepository {
    suspend fun getAllCategories() : CategoriesDomain
    suspend fun getAllMealsByCategories(category: String) : MealsDomain
    suspend fun getDetailMealByName(mealName: String) : DetailMealsDomain
    suspend fun getAllMealsRecipeUseCase(): List<RecipeEntity>

    suspend fun insertFavoriteRecipe(mealEntity: RecipeEntity)

    suspend fun deleteFavoriteRecipe(mealEntity: RecipeEntity)
}