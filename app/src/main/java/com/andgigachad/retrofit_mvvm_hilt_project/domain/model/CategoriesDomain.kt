package com.andgigachad.retrofit_mvvm_hilt_project.domain.model

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import com.google.gson.annotations.SerializedName

data class CategoriesDomain(
    var categories: List<Category>
)