package com.andgigachad.retrofit_mvvm_hilt_project.data.repository

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.domain.util.MealsDomainMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.MealsMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork

class FavoriteMealRepositoryImpl(
    private val recipeService: RetrofitService,
    private val categoriesMapper: CategoriesMapper,
    private val mealsMapper : MealsMapper,
) : FavoriteMealRepository {

    override suspend fun getAllCategories(): CategoriesDomain {
        return categoriesMapper.mapToDomainModel(recipeService.getAllCategoriesOfMeal())
    }

    override suspend fun getAllMealsByCategories(category: String): MealsDomain {
        return mealsMapper.mapToDomainModel(recipeService.getAllMealsByCategory(category))
    }
}