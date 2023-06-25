package com.andgigachad.retrofit_mvvm_hilt_project.network.mappers

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.util.MealsDomainMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.MealsNetwork

class MealsMapper : MealsDomainMapper<MealsNetwork, MealsDomain> {
    override fun mapToDomainModel(networkModel: MealsNetwork): MealsDomain {
        return MealsDomain(
            networkModel.meals
        )
    }

    override fun mapToNetworkModel(domainModel: MealsDomain): MealsNetwork {
        TODO("Not yet implemented")
    }
}