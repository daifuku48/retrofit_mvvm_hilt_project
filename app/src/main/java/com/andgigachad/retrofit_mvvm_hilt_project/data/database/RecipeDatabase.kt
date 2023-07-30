package com.andgigachad.retrofit_mvvm_hilt_project.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos.RecipeDAO
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 8, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDAO() : RecipeDAO
}