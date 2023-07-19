package com.andgigachad.retrofit_mvvm_hilt_project.di

import com.andgigachad.retrofit_mvvm_hilt_project.data.internet.NetworkChecker
import com.andgigachad.retrofit_mvvm_hilt_project.data.internet.NetworkCheckerImpl
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.CheckInternetConnectionUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllMealsByCategoriesUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetDetailMealUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

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

    @Provides
    fun provideGetDetailMealUseCase(favoriteMealRepository: FavoriteMealRepository) : GetDetailMealUseCase {
        return GetDetailMealUseCase(
            favoriteMealRepository = favoriteMealRepository
        )
    }

    @Provides
    fun provideCheckInternetConnectionUseCase(networkChecker: NetworkCheckerImpl) : CheckInternetConnectionUseCase {
        return CheckInternetConnectionUseCase(
            networkChecker = networkChecker
        )
    }
}