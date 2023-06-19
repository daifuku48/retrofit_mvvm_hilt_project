package com.andgigachad.retrofit_mvvm_hilt_project.domain

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork


class GetAllCategoriesMealUseCase(
    private val favoriteMealRepository: FavoriteMealRepository,
    private val mapper: CategoriesMapper) {
    suspend fun execute() : CategoriesNetwork
    {
        return mapper.mapToModel(favoriteMealRepository.getAllCategories())
    }
}