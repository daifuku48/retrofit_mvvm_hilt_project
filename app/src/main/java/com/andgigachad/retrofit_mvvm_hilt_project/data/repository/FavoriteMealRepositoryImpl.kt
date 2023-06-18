package com.andgigachad.retrofit_mvvm_hilt_project.data.repository

import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork
import retrofit2.Response

class FavoriteMealRepositoryImpl(
    private val recipeService: RetrofitService,
    private val mapper: CategoriesNetwork
) : FavoriteMealRepository {

    override suspend fun getAllCategories(): Response<CategoriesNetwork> {
        return recipeService.getAllCategoriesOfMeal()
    }
}