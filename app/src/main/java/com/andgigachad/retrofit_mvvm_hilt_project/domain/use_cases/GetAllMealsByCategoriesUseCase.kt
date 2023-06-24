package com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import javax.inject.Inject

class GetAllMealsByCategoriesUseCase @Inject constructor(
    private val favoriteMealRepository: FavoriteMealRepository
) {
    suspend fun execute() : MealsDomain
    {
        return favoriteMealRepository.getAllMealsByCategories()
    }
}