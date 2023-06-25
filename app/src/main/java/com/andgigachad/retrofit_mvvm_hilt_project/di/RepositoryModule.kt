package com.andgigachad.retrofit_mvvm_hilt_project.di

import com.andgigachad.retrofit_mvvm_hilt_project.data.repository.FavoriteMealRepositoryImpl
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.MealsMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCategoriesMapper(): CategoriesMapper {
        return CategoriesMapper()
    }

    @Provides
    fun providesMealsMapper() : MealsMapper {
        return MealsMapper()
    }

    @Singleton
    @Provides
    fun provideFavoriteMealRepository(
        recipeService: RetrofitService,
        mapperCategories: CategoriesMapper,
        mapperMeals: MealsMapper
    ) : FavoriteMealRepository {
        return FavoriteMealRepositoryImpl(
            recipeService = recipeService,
            categoriesMapper = mapperCategories,
            mealsMapper = mapperMeals
        )
    }
}