package com.andgigachad.retrofit_mvvm_hilt_project.network

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealsNetwork
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("categories.php")
    suspend fun getAllCategoriesOfMeal() : CategoriesNetwork

    @GET("categp")
    suspend fun getAllMealsByCategory() : MealsNetwork

    companion object{
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }
}