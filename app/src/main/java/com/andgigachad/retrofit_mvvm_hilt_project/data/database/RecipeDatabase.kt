package com.andgigachad.retrofit_mvvm_hilt_project.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos.RecipeDAO
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 7)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDAO() : RecipeDAO
}