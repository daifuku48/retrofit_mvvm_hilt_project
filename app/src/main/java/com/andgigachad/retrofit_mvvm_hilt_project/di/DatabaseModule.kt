package com.andgigachad.retrofit_mvvm_hilt_project.di

import android.app.Application
import androidx.room.Room
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.RecipeDatabase
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos.RecipeDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideRecipeDatabase(application: Application) : RecipeDatabase {
        return Room.databaseBuilder(
            application,
            RecipeDatabase::class.java,
            "recipe_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideRecipeDAO(database: RecipeDatabase) : RecipeDAO {
        return database.recipeDAO()
    }
}