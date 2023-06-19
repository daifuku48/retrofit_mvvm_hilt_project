package com.andgigachad.retrofit_mvvm_hilt_project.network

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork
import retrofit2.http.GET

interface RetrofitService {
    @GET("/categories.php")
    fun getAllCategoriesOfMeal() : CategoriesNetwork
    companion object{
        const val BASE_URL = "http://www.themealdb.com/api/json/v1/1/"
    }
}