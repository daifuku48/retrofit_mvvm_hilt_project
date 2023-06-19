package com.andgigachad.retrofit_mvvm_hilt_project.data.repository

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper

class FavoriteMealRepositoryImpl(
    private val recipeService: RetrofitService,
    private val mapper: CategoriesMapper
) : FavoriteMealRepository {

    override suspend fun getAllCategories(): CategoriesDomain {
        return mapper.mapToDomainModel(recipeService.getAllCategoriesOfMeal())
    }
}