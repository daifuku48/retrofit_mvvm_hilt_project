package com.andgigachad.retrofit_mvvm_hilt_project.data.repository

import com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos.RecipeDAO
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.DetailMealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.DetailMealMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.MealsMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealsNetwork

class FavoriteMealRepositoryImpl(
    private val recipeService: RetrofitService,
    private val categoriesMapper: CategoriesMapper,
    private val mealsMapper : MealsMapper,
    private val detailMealsMapper: DetailMealMapper,
    private val recipeDAO: RecipeDAO
) : FavoriteMealRepository {

    override suspend fun getAllCategories(): CategoriesDomain {
        return categoriesMapper.mapToDomainModel(recipeService.getAllCategoriesOfMeal())
    }

    override suspend fun getAllMealsByCategories(category: String): MealsDomain {
        return mealsMapper.mapToDomainModel(recipeService.getAllMealsByCategory(category))
    }

    override suspend fun getDetailMealByName(mealName: String): DetailMealsDomain {
        return detailMealsMapper.mapToDomainModel(recipeService.getDetailMealByName(mealName))
    }

    override fun getAllMealsRecipeUseCase(): List<RecipeEntity> {
        return recipeDAO.getAllRecipe()
    }

    override suspend fun insertFavoriteRecipe(mealEntity: RecipeEntity) {
        return recipeDAO.insert(mealEntity)
    }

    override suspend fun deleteFavoriteRecipe(mealEntity: RecipeEntity) {
        return recipeDAO.delete(mealEntity)
    }

}