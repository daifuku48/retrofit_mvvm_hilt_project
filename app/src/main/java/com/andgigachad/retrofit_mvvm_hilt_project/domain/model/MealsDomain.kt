package com.andgigachad.retrofit_mvvm_hilt_project.domain.model

import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Meal
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealsNetwork

data class MealsDomain(
    var meals: List<Meal>
)