package com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.DetailMealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealsNetwork
import javax.inject.Inject

class GetDetailMealUseCase @Inject constructor(
    private val favoriteMealRepository: FavoriteMealRepository
) {
    suspend fun execute(mealName: String) : DetailMealsDomain {
        return favoriteMealRepository.getDetailMealByName(
            mealName = mealName
        )
    }
}