package com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork
import retrofit2.Call
import javax.inject.Inject


class GetAllCategoriesMealUseCase @Inject constructor(
    private val favoriteMealRepository: FavoriteMealRepository
    ) {
    suspend fun execute() : CategoriesDomain
    {
        return favoriteMealRepository.getAllCategories()
    }
}