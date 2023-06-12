package com.andgigachad.retrofit_mvvm_hilt_project.network.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("categories")
    private var categories: List<Category>
    )