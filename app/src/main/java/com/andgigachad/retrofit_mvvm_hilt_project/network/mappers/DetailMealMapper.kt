package com.andgigachad.retrofit_mvvm_hilt_project.network.mappers

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.DetailMealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.util.Mapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealsNetwork

class DetailMealMapper : Mapper<DetailMealsNetwork, DetailMealsDomain> {
    override fun mapToDomainModel(networkModel: DetailMealsNetwork): DetailMealsDomain {
        return DetailMealsDomain(
            networkModel.meals
        )
    }

    override fun mapToNetworkModel(domainModel: DetailMealsDomain): DetailMealsNetwork {
        return DetailMealsNetwork(
            domainModel.meals
        )
    }
}