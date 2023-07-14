package com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases

import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import javax.inject.Inject

class GetAllMealsRecipeEntityUseCase @Inject constructor(
    private val repository: FavoriteMealRepository
) {
    suspend fun execute() = repository.getAllMealsRecipeUseCase()
}