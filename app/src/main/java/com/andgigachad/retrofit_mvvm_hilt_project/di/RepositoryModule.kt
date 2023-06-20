package com.andgigachad.retrofit_mvvm_hilt_project.di

import com.andgigachad.retrofit_mvvm_hilt_project.data.repository.FavoriteMealRepositoryImpl
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import com.andgigachad.retrofit_mvvm_hilt_project.network.mappers.CategoriesMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFavoriteMealRepository(
        recipeService: RetrofitService,
        mapper: CategoriesMapper
    ) : FavoriteMealRepository {
        return FavoriteMealRepositoryImpl(
            recipeService = recipeService,
            mapper = mapper)
    }
}