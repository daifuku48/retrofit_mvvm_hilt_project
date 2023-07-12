package com.andgigachad.retrofit_mvvm_hilt_project.data.database

import androidx.room.Database
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos.RecipeDAO
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
abstract class RecipeDatabase {
    abstract fun recipeDAO() : RecipeDAO
}