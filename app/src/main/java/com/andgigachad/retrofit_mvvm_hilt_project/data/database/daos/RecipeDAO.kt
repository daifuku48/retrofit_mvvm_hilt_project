package com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity

@Dao
interface RecipeDAO{
    @Insert
    fun insert(recipeEntity: RecipeEntity)

    @Delete
    fun delete(recipeEntity: RecipeEntity)

    @Query("SELECT * FROM recipe_table")
    fun getAllRecipe(): List<RecipeEntity>
}