package com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity

@Dao
interface RecipeDAO{
    @Insert
    suspend fun insert(recipeEntity: RecipeEntity)

    @Delete
    suspend fun delete(recipeEntity: RecipeEntity)

    @Query("SELECT * FROM RECIPE_TABLE")
    fun getAllRecipe() : List<RecipeEntity>
}