package com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases

import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import javax.inject.Inject

class InsertFavoriteMealUseCase @Inject constructor(
    private val repository: FavoriteMealRepository
) {
    suspend fun execute(mealEntity: RecipeEntity) {
        return repository.insertFavoriteRecipe(
            mealEntity = mealEntity
        )
    }
}