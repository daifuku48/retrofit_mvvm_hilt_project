package com.andgigachad.retrofit_mvvm_hilt_project.network.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    var idCategory: String,
    @SerializedName("strCategory")
    var strCategory: String,
    @SerializedName("strCategoryThumb")
    var strCategoryThumb: String,
    @SerializedName("strCategoryDescription")
    var strCategoryDescription: String
)