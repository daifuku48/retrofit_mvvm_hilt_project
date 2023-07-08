package com.andgigachad.retrofit_mvvm_hilt_project.domain.model

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealNetwork

data class MealsDomain(
    var meals: List<MealNetwork>
)