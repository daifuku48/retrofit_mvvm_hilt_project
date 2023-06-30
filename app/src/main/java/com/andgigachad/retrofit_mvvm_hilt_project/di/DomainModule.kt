package com.andgigachad.retrofit_mvvm_hilt_project.di

import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsByCategoriesUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.SaveCategoryNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideSaveCategoryNameUseCase(favoriteMealRepository: FavoriteMealRepository) : SaveCategoryNameUseCase {
        return SaveCategoryNameUseCase(
            favoriteMealRepository = favoriteMealRepository
        )
    }


    @Provides
    fun provideGetAllCategoriesMealUseCase(favoriteMealRepository: FavoriteMealRepository) : GetAllCategoriesMealUseCase {
        return GetAllCategoriesMealUseCase(
            favoriteMealRepository = favoriteMealRepository
        )
    }

    @Provides
    fun provideGetAllMealsByCategoriesUseCase(favoriteMealRepository: FavoriteMealRepository) : GetAllMealsByCategoriesUseCase {
        return GetAllMealsByCategoriesUseCase(
            favoriteMealRepository = favoriteMealRepository
        )
    }
}