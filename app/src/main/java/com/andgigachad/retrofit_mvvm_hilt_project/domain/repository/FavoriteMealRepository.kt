package com.andgigachad.retrofit_mvvm_hilt_project.domain.repository

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealsNetwork
import retrofit2.Call

interface FavoriteMealRepository {
    suspend fun getAllCategories() : CategoriesDomain
    suspend fun getAllMealsByCategories(category: String) : MealsDomain
    suspend fun getDetailMealByName(mealName: String) : MealsDomain
}