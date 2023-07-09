package com.andgigachad.retrofit_mvvm_hilt_project.domain.repository

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.DetailMealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain

interface FavoriteMealRepository {
    suspend fun getAllCategories() : CategoriesDomain
    suspend fun getAllMealsByCategories(category: String) : MealsDomain
    suspend fun getDetailMealByName(mealName: String) : DetailMealsDomain
}