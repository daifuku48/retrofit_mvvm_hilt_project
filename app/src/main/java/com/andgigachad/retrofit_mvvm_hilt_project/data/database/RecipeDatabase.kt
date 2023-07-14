package com.andgigachad.retrofit_mvvm_hilt_project.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.daos.RecipeDAO
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 3)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDAO() : RecipeDAO

    companion object {
        private var INSTANCE: RecipeDatabase? = null

        fun getInstance(context: Context): RecipeDatabase?{
            if (INSTANCE == null){
                synchronized(RecipeDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        RecipeDatabase::class.java,
                        "recipe_db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}