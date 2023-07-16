package com.andgigachad.retrofit_mvvm_hilt_project.di

import android.app.Application
import android.content.Context
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

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun provideDatabase(context: Context) : RecipeDatabase {
        return Room.databaseBuilder(context,
            RecipeDatabase::class.java,
            "recipe_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideRecipeDAO(database: RecipeDatabase) : RecipeDAO {
        return database.recipeDAO()
    }
}