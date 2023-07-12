package com.andgigachad.retrofit_mvvm_hilt_project.domain.model

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealNetwork
import com.google.gson.annotations.SerializedName

data class DetailMealsDomain(
    var meals: List<DetailMealNetwork>
)
