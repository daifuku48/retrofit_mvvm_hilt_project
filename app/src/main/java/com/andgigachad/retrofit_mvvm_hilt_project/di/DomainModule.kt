package com.andgigachad.retrofit_mvvm_hilt_project.di

import com.andgigachad.retrofit_mvvm_hilt_project.domain.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetAllCategoriesMealUseCase(favoriteMealRepository: FavoriteMealRepository) : GetAllCategoriesMealUseCase{
        return GetAllCategoriesMealUseCase(
            favoriteMealRepository = favoriteMealRepository,
            mapper = CategoriesMapper()
        )
    }
}