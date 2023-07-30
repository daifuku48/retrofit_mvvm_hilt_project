package com.andgigachad.retrofit_mvvm_hilt_project.di

import android.content.Context
import androidx.room.Room
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.RecipeDatabase
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos.RecipeDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    //activity context predict out of memory more than Application Context
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) : RecipeDatabase {
        return Room.databaseBuilder(appContext,
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