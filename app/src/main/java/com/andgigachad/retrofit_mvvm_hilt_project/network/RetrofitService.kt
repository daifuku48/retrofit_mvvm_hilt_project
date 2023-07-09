package com.andgigachad.retrofit_mvvm_hilt_project.network

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealsNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealsNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("categories.php")
    suspend fun getAllCategoriesOfMeal() : CategoriesNetwork

    @GET("filter.php")
    suspend fun getAllMealsByCategory(@Query("c") categoryName: String) : MealsNetwork

    @GET("search.php")
    suspend fun getDetailMealByName(@Query("s") mealName: String) : DetailMealsNetwork

    companion object{
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }
}