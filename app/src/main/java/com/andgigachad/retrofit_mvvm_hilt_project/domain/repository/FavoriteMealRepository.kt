package com.andgigachad.retrofit_mvvm_hilt_project.domain.repository

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork

interface FavoriteMealRepository {
    suspend fun getAllCategories() : CategoriesDomain
}