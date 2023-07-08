package com.andgigachad.retrofit_mvvm_hilt_project.network.model

import com.google.gson.annotations.SerializedName

data class MealNetwork(
    @SerializedName("strMeal")
    var strMeal: String,
    @SerializedName("strMealThumb")
    var strMealThumb: String,
    @SerializedName("idMeal")
    var idMeal: String
)
