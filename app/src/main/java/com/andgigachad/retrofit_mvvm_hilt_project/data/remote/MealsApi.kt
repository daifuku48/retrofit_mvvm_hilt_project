package com.andgigachad.retrofit_mvvm_hilt_project.data.remote

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Categories
import retrofit2.Response
import retrofit2.http.GET


interface MealsApi {

    @GET("/categories.php")
    fun getAllCategoriesOfMeal() : Response<Categories>
    companion object{
       const val BASE_URL = "www.themealdb.com/api/json/v1/1/"
    }
}